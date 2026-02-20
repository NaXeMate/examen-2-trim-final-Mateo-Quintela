package edu.examen.misionEstelar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.examen.misionEstelar.model.entities.Tripulante;

public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {
    public Tripulante findByLicenciaEstelar(String licenciaEstelar);
}
