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
    private final PacienteRepository pacienteRepository;



    @Override
    public Paciente autenticarPaciente(String correoElectronico, String contraseña) {
        return pacienteRepository.findByCorreoElectronicoAndContrasena(correoElectronico, contraseña);
    }
    @Override
    public Paciente obtenerPacientePorCorreoElectronico(String correoElectronico) {
        return pacienteRepository.findByCorreoElectronico(correoElectronico);
    }

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Long id, Paciente pacienteActualizado) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con el id: " + id));
        pacienteExistente.setNombre(pacienteActualizado.getNombre());
        pacienteExistente.setApellido(pacienteActualizado.getApellido());
        pacienteExistente.setCorreoElectronico(pacienteActualizado.getCorreoElectronico());
        pacienteExistente.setContraseña(pacienteActualizado.getContraseña());
        return pacienteRepository.save(pacienteExistente);
    }

    @Override
    public Optional<Paciente> obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> obtenerTodosPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    // Otros métodos existentes...
}
