package com.pia.MediSite.Controllers.Cita.impl;

import com.pia.MediSite.Controllers.Cita.CitaControllers;
import com.pia.MediSite.Entity.cita.Cita;
import com.pia.MediSite.Services.Cita.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cita")
public class CitaControllersImpl implements CitaControllers {
    private final CitaService citaService;


    public CitaControllersImpl(CitaService citaService) {
        this.citaService = citaService;


    }

    @Override
    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        return citaService.crearCita(cita);
    }

    @Override
    @GetMapping("/{id}")
    public Cita buscarId(@PathVariable long id) {
        return citaService.buscarporId(id);
    }

    @Override
    @PutMapping("/{id}")
    public Cita actualizar(@RequestBody Cita cita,@PathVariable long id) {
        return citaService.actualizarCita(cita,id);
    }


}
