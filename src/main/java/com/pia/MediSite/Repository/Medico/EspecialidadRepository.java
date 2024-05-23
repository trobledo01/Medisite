package com.pia.MediSite.Repository.Medico;

import com.pia.MediSite.Entity.medico.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    Optional<Especialidad> findById(Long id);
}
