package com.pia.MediSite.Repository.Paciente;

import com.pia.MediSite.Entity.medico.Ciudad;
import com.pia.MediSite.Entity.medico.Especialidad;
import com.pia.MediSite.Entity.medico.Medico;
import com.pia.MediSite.Entity.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena);

        Optional<Paciente> findByCorreoElectronico(String correoElectronico);

}
