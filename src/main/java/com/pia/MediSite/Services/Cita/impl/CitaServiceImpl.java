package com.pia.MediSite.Services.Cita.impl;

import com.pia.MediSite.Entity.cita.Cita;
import com.pia.MediSite.Repository.Cita.CitaRepository;
import com.pia.MediSite.Services.Cita.CitaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CitaServiceImpl implements CitaService {
    CitaRepository citaRepository;

    @Override
    public Cita buscarporId(long id) {
        return citaRepository.findById(id);
    }

    @Override
    public Cita crearCita(Cita cita) {

        return citaRepository.save(cita);
    }

    @Override
    public Cita actualizarCita(Cita cita, long id) {
        Cita cita1= citaRepository.findById(id);

        cita1.setEstatus(cita.getEstatus());
        cita1.setCita_Id(cita.getCita_Id());
        cita1.setFechaCita(cita.getFechaCita());
        cita1.setPaciente(cita.getPaciente());
        cita1.setCiudad(cita.getCiudad());
        cita1.setMedico(cita.getMedico());

        return  citaRepository.save(cita1);


    }
}
