package edu.examen.misionEstelar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.examen.misionEstelar.model.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    public Persona findByLicenciaEstelar(String licenciaEstelar);
}
