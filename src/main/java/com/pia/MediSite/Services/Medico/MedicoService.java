package com.pia.MediSite.Services.Medico;



import com.pia.MediSite.Entity.medico.Medico;


import java.util.List;

public interface MedicoService {
    List<Medico> obtenerTodos();
    Medico obtenerPorId(Long id);
    List<Medico> buscarPorEspecialidad(Long especialidadId);
    List<Medico> buscarPorCiudad(Long ciudadId);

    Medico agregarMedico(Medico medico);
    Medico actualizarMedico(Long id, Medico medicoActualizado);

    public void deleteMedicoById(Long id);
}