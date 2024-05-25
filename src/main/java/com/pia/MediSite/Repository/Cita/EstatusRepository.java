package com.pia.MediSite.Repository.Cita;

import com.pia.MediSite.Entity.cita.Cita;
import com.pia.MediSite.Entity.cita.Estatus;
import com.pia.MediSite.Entity.medico.Ciudad;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstatusRepository {
    Optional<Estatus> findById(Long id);
}
