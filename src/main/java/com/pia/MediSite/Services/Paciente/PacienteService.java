package com.pia.MediSite.Services.Paciente;

import com.pia.MediSite.Entity.paciente.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    Paciente autenticarPaciente(String correoElectronico, String contraseña);
    Paciente crearPaciente(Paciente paciente);
    Paciente actualizarPaciente(Long id, Paciente pacienteActualizado);
    Optional<Paciente> obtenerPacientePorId(Long id);
    List<Paciente> obtenerTodosPacientes();
    void eliminarPaciente(Long id);
    Optional<Paciente> obtenerPacientePorCorreoElectronico(String correoElectronico);

}
