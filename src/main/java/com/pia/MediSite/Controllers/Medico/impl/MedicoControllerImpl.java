package com.pia.MediSite.Controllers.Medico.impl;

import com.pia.MediSite.Controllers.Medico.MedicoController;
import com.pia.MediSite.Entity.medico.Medico;
import com.pia.MediSite.Services.Medico.MedicoService;
import com.pia.MediSite.Services.Medico.impl.MedicoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoControllerImpl implements MedicoController {
    private final MedicoService medicoService;

    public MedicoControllerImpl(MedicoServiceImpl medicoService) {
        this.medicoService = medicoService;
    }

    @Override
    @GetMapping
    public List<Medico> obtenerTodos() {
        return medicoService.obtenerTodos();
    }

    @Override
    @GetMapping("/{id}")
    public Medico obtenerPorId(@PathVariable Long id) {
        return medicoService.obtenerPorId(id);
    }

    @Override
    @GetMapping(params = "especialidad")
    public List<Medico> obtenerPorEspecialidad(@RequestParam Long especialidad) {
        return medicoService.buscarPorEspecialidad(especialidad);
    }

    @Override
    @GetMapping(params = "ciudad")
    public List<Medico> obtenerPorCiudad(@RequestParam Long ciudad) {
        return medicoService.buscarPorCiudad(ciudad);
    }



    @Override
    @PostMapping
    public Medico agregarMedico(@RequestBody Medico medico) {
        return medicoService.agregarMedico(medico);
    }

    @Override
    @PutMapping("/{id}")
    public Medico actualizarMedico(@PathVariable Long id, @RequestBody Medico medicoActualizado) {
        return medicoService.actualizarMedico(id, medicoActualizado);
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicoById(@PathVariable Long id) {
        medicoService.deleteMedicoById(id);
        return ResponseEntity.ok().build();
    }
}