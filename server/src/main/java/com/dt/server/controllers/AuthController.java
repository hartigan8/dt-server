package com.dt.server.controllers;

import com.dt.server.entities.Token;
import com.dt.server.entities.User;
import com.dt.server.repos.TokenRepo;
import com.dt.server.repos.UserRepo;
import com.dt.server.requests.AuthRequest;
import com.dt.server.requests.RegisterRequest;
import com.dt.server.responses.AuthResponse;
import com.dt.server.security.JwtTokenProvider;
import com.dt.server.security.UserDetailsImp;
import com.dt.server.services.RoleService;
import com.dt.server.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private UserService userService;
    private PasswordEncoder encoder;
    private AuthenticationManager authManager;
    private JwtTokenProvider tokenProvider;

    private RoleService roleService;
    private TokenRepo tokenRepo;

    private AuthenticationManager authenticationManager;
    private final UserRepo userRepo;


    public AuthController(UserService userService, PasswordEncoder encoder, AuthenticationManager authManager,
                          JwtTokenProvider tokenProvider, RoleService roleService, TokenRepo tokenRepo,
                          UserRepo userRepo, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.encoder = encoder;
        this.authManager = authManager;
        this.tokenProvider = tokenProvider;
        this.roleService = roleService;
        this.tokenRepo = tokenRepo;
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(roleService.findRole("user"))
                .build();
        User savedUser = userService.save(user);
        UserDetailsImp userDetailsImp = UserDetailsImp.create(user);
        String jwtToken = tokenProvider.generateToken(userDetailsImp);
        String refreshToken = tokenProvider.generateRefreshToken(userDetailsImp);
        saveUserToken(savedUser, jwtToken);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepo.save(token);
    }

    @PostMapping("login")
    public AuthResponse authenticate(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepo.findByEmail(request.getEmail()).orElseThrow();
        UserDetailsImp userDetailsImp = UserDetailsImp.create(user);
        var jwtToken = tokenProvider.generateToken(userDetailsImp);
        var refreshToken = tokenProvider.generateRefreshToken(userDetailsImp);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepo.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(validUserTokens);
    }
}
