package edu.examen.misionEstelar.model.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "nave")
public class Nave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_nave", nullable = false)
    private String nombreNave;

    @Column(nullable = false)
    private String modelo;

    @Column(name = "capacidad")
    private int capacidadPasajeros;

    @OneToMany(mappedBy = "nave", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MisionAsignada> misionAsignada;

    public Nave(Long id, String nombreNave, String modelo, int capacidadPasajeros) {
        this.id = id;
        this.nombreNave = nombreNave;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreNave() {
        return nombreNave;
    }

    public void setNombreNave(String nombreNave) {
        this.nombreNave = nombreNave;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public List<MisionAsignada> getMisionAsignada() {
        return misionAsignada;
    }

    public void setMisionAsignada(List<MisionAsignada> misionAsignada) {
        this.misionAsignada = misionAsignada;
    }

    
    
}
