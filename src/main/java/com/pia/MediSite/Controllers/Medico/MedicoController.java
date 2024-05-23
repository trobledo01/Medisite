package com.pia.MediSite.Controllers.Medico;

import com.pia.MediSite.Entity.medico.Medico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface MedicoController {
    List<Medico> obtenerTodos();
    Medico obtenerPorId(Long id);
    List<Medico> obtenerPorEspecialidad(Long especialidad);
    List<Medico> obtenerPorCiudad(Long ciudad);

    Medico agregarMedico(Medico medico);
    Medico actualizarMedico(Long id, Medico medicoActualizado);

    ResponseEntity<?> deleteMedicoById(Long id) ;

}
