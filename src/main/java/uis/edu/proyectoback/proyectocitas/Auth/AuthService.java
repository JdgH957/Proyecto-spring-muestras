package uis.edu.proyectoback.proyectocitas.Auth;

import uis.edu.proyectoback.proyectocitas.modelo.User;
import uis.edu.proyectoback.proyectocitas.modelo.Role;
import uis.edu.proyectoback.proyectocitas.repositorio.UserRepositorio;
import uis.edu.proyectoback.proyectocitas.Jwt.JwtService;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepositorio userRepository; 
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token=jwtService.getToken(user);
        User user_id = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found")); 
        Long userId = user_id.getId();
        return AuthResponse.builder()
            .token(token)
            .userId(userId)
            .build();
    }
    
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .email(request.getEmail())
            .role(Role.USER)
            .build();

        userRepository.save(user);
        
        long user_id = user.getId();

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .userId(user_id)    
            .build();
    }    
}
