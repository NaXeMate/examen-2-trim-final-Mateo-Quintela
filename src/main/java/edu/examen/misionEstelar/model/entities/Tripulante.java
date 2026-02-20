package edu.examen.misionEstelar.model.entities;

import java.util.List;

import edu.examen.misionEstelar.model.enumerated.Rango;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tripulante")
public class Tripulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 55)
    private String nombre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rango rango;

    @Column(name = "licencia_estelar", unique = true, nullable = false)
    private String licenciaEstelar;

    @OneToMany(mappedBy = "tripulante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MisionAsignada> misionAsignada;

    public Tripulante() {}
    
    public Tripulante(String nombre, Rango rango, String licenciaEstelar) {
        this.nombre = nombre;
        this.rango = rango;
        this.licenciaEstelar = licenciaEstelar;
    }
    
    public Tripulante(Long id, String nombre, Rango rango, String licenciaEstelar) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.licenciaEstelar = licenciaEstelar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public String getLicenciaEstelar() {
        return licenciaEstelar;
    }

    public void setLicenciaEstelar(String licenciaEstelar) {
        this.licenciaEstelar = licenciaEstelar;
    }

    public List<MisionAsignada> getMisionAsignada() {
        return misionAsignada;
    }

    public void setMisionAsignada(List<MisionAsignada> misionAsignada) {
        this.misionAsignada = misionAsignada;
    }
}
