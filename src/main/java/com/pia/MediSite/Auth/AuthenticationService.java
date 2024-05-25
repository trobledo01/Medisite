package com.pia.MediSite.Auth;

import com.pia.MediSite.Config.JwtService;
import com.pia.MediSite.Entity.paciente.Paciente;
import com.pia.MediSite.Entity.paciente.Role;
import com.pia.MediSite.Repository.Paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PacienteRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request)
    {
        var paciente = Paciente.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .correoElectronico(request.getCorreoPaciente())
                .contrasena(passwordEncoder.encode(request.getContrasena()))
                .role(Role.USER)
                .build();
        repository.save(paciente);
        var jwtToken = jwtService.generateToken(paciente);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getCorreoPaciente(),
                        request.getContrasena()
                )
        );
        var paciente = repository.findByCorreoElectronico(request.getCorreoPaciente())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(paciente);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
