package edu.examen.misionEstelar.model.entities;

import edu.examen.misionEstelar.model.enumerated.EstadoMision;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mision_asignada")
public class MisionAsignada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tripulante_id")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nave_id")
    private Nave nave;

    @Column(name = "fecha_estelar")
    private Double fechaEstelar;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoMision estadoMision;

    @Column(name = "presupuesto")
    private Double presupuestoMision;

    public MisionAsignada() {}    
    
    public MisionAsignada(Double fechaEstelar, EstadoMision estadoMision, Double presupuestoMision) {
        this.fechaEstelar = fechaEstelar;
        this.estadoMision = estadoMision;
        this.presupuestoMision = presupuestoMision;
    }

    public MisionAsignada(Long id, Double fechaEstelar, EstadoMision estadoMision, Double presupuestoMision) {
        this.id = id;
        this.fechaEstelar = fechaEstelar;
        this.estadoMision = estadoMision;
        this.presupuestoMision = presupuestoMision;
    }

    public MisionAsignada(Long id, Persona persona, Nave nave, Double fechaEstelar,
            EstadoMision estadoMision, Double presupuestoMision) {
        this.id = id;
        this.persona = persona;
        this.nave = nave;
        this.fechaEstelar = fechaEstelar;
        this.estadoMision = estadoMision;
        this.presupuestoMision = presupuestoMision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getFechaEstelar() {
        return fechaEstelar;
    }

    public void setFechaEstelar(Double fechaEstelar) {
        this.fechaEstelar = fechaEstelar;
    }

    public EstadoMision getEstadoMision() {
        return estadoMision;
    }

    public void setEstadoMision(EstadoMision estadoMision) {
        this.estadoMision = estadoMision;
    }

    public Double getPresupuestoMision() {
        return presupuestoMision;
    }

    public void setPresupuestoMision(Double presupuestoMision) {
        this.presupuestoMision = presupuestoMision;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

}
