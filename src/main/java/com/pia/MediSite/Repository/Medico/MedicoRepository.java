package com.pia.MediSite.Repository.Medico;

import com.pia.MediSite.Entity.medico.Ciudad;
import com.pia.MediSite.Entity.medico.Especialidad;
import com.pia.MediSite.Entity.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository  extends JpaRepository<Medico, Long> {
    List<Medico> findAll();
    List<Medico> findByEspecialidad(Especialidad especialidad);
    List<Medico> findByCiudad(Ciudad ciudad);

    Optional<Medico> findById(Long id);

    Medico save(Medico medico);

    void deleteById(Long id);
}
