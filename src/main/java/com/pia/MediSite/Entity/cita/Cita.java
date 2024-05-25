package com.pia.MediSite.Entity.cita;

import com.pia.MediSite.Entity.medico.Ciudad;
import com.pia.MediSite.Entity.medico.Medico;
import com.pia.MediSite.Entity.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cita_Id", nullable = false)
    private Long cita_Id; //Id de la cita en MySQL.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_Id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_Id")
    private Paciente paciente;

    private Date fechaCita;

    public Long getCita_Id() {
        return cita_Id;
    }

    public void setCita_Id(Long cita_Id) {
        this.cita_Id = cita_Id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "estatus_id")
    private Estatus estatus;

}
