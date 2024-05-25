package com.pia.MediSite.Controllers.Cita;

import com.pia.MediSite.Entity.cita.Cita;

import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CitaControllers {

    Cita crearCita(Cita cita) ;

    Cita buscarId(long id);

    Cita actualizar(Cita cita, long id);



}
