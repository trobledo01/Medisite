package com.pia.MediSite.Services.Cita;

import com.pia.MediSite.Entity.cita.Cita;

import java.util.List;

public interface CitaService {
    Cita buscarporId(long id);
    Cita crearCita(Cita cita);

    Cita actualizarCita(Cita cita,long id);

}
