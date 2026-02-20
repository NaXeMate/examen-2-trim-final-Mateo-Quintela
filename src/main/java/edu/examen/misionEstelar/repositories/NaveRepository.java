package edu.examen.misionEstelar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.examen.misionEstelar.model.entities.Nave;

public interface NaveRepository extends JpaRepository<Nave, Long> {}
