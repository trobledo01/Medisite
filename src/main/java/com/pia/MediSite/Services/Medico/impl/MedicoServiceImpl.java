package com.pia.MediSite.Services.Medico.impl;

import com.pia.MediSite.Entity.medico.Ciudad;
import com.pia.MediSite.Entity.medico.Especialidad;
import com.pia.MediSite.Entity.medico.Medico;
import com.pia.MediSite.Repository.Medico.CiudadRepository;
import com.pia.MediSite.Repository.Medico.EspecialidadRepository;
import com.pia.MediSite.Repository.Medico.MedicoRepository;
import com.pia.MediSite.Services.Medico.MedicoService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
    private final MedicoRepository medicoRepository;
    private final EspecialidadRepository especialidadRepository;
    private final CiudadRepository ciudadRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository,
                             EspecialidadRepository especialidadRepository,
                             CiudadRepository ciudadRepository) {
        this.medicoRepository = medicoRepository;
        this.especialidadRepository = especialidadRepository;
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Medico> obtenerTodos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico obtenerPorId(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico no encontrado"));
    }

    @Override
    public List<Medico> buscarPorEspecialidad(Long especialidadId) {
        Especialidad especialidad = especialidadRepository.findById(especialidadId)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));
        return medicoRepository.findByEspecialidad(especialidad);
    }

    @Override
    public List<Medico> buscarPorCiudad(Long ciudadId) {
        Ciudad ciudad = ciudadRepository.findById(ciudadId)
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad no encontrada"));
        return medicoRepository.findByCiudad(ciudad);
    }



    @Override
    public Medico agregarMedico(Medico medico) {
        Especialidad especialidad = especialidadRepository.findById(medico.getEspecialidad().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));
        Ciudad ciudad = ciudadRepository.findById(medico.getCiudad().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad no encontrada"));

        medico.setEspecialidad(especialidad);
        medico.setCiudad(ciudad);
        return medicoRepository.save(medico);
    }

    @Override
    public Medico actualizarMedico(Long id, Medico medicoActualizado) {
        Medico medicoExistente = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico no encontrado"));

        Especialidad especialidad = especialidadRepository.findById(medicoActualizado.getEspecialidad().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));
        Ciudad ciudad = ciudadRepository.findById(medicoActualizado.getCiudad().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad no encontrada"));

        medicoExistente.setNombre(medicoActualizado.getNombre());
        medicoExistente.setApellido(medicoActualizado.getApellido());
        medicoExistente.setEspecialidad(especialidad);
        medicoExistente.setCiudad(ciudad);
        medicoExistente.setHoraInicio(medicoActualizado.getHoraInicio());
        medicoExistente.setHoraFin(medicoActualizado.getHoraFin());

        return medicoRepository.save(medicoExistente);
    }

    @Override
    public void deleteMedicoById(Long id) {
        medicoRepository.deleteById(id);
    }
}
