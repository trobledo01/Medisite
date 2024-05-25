package com.pia.MediSite.Services.Paciente.impl;

import com.pia.MediSite.Entity.paciente.Paciente;
import com.pia.MediSite.Repository.Paciente.PacienteRepository;
import com.pia.MediSite.Services.Paciente.PacienteService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Override
    public Paciente autenticarPaciente(String correoElectronico, String contraseña) {
        return null;
    }

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente actualizarPaciente(Long id, Paciente pacienteActualizado) {
        return null;
    }

    @Override
    public Optional<Paciente> obtenerPacientePorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Paciente> obtenerTodosPacientes() {
        return List.of();
    }

    @Override
    public void eliminarPaciente(Long id) {

    }

    @Override
    public Optional<Paciente> obtenerPacientePorCorreoElectronico(String correoElectronico) {
        return Optional.empty();
    }
}
