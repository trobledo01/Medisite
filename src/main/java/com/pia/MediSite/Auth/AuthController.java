package com.pia.MediSite.Auth;

import com.pia.MediSite.Config.JwtService;
import com.pia.MediSite.Entity.paciente.Paciente;
import com.pia.MediSite.Services.Paciente.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final PacienteService pacienteService;

    public AuthController(JwtService jwtService, PacienteService pacienteService) {
        this.jwtService = jwtService;
        this.pacienteService = pacienteService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CredencialesDto credenciales) {
        Paciente paciente = pacienteService.autenticarPaciente(credenciales.getCorreoElectronico(), credenciales.getContrasena());
        if (paciente != null) {
            String token = jwtService.generateToken(paciente);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteExistente = pacienteService.obtenerPacientePorCorreoElectronico(paciente.getCorreoElectronico());
        if (pacienteExistente != null) {
            return ResponseEntity.badRequest().build();
        }
        Paciente pacienteNuevo = pacienteService.crearPaciente(paciente);
        return ResponseEntity.ok(pacienteNuevo);
    }
}