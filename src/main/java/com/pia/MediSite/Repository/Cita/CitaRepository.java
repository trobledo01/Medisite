package com.pia.MediSite.Repository.Cita;

import com.pia.MediSite.Entity.cita.Cita;
import com.pia.MediSite.Entity.medico.Ciudad;
import com.pia.MediSite.Entity.medico.Medico;
import com.pia.MediSite.Entity.paciente.Paciente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository {


    Cita save(Cita cita);

    Cita findById(long id);
}
