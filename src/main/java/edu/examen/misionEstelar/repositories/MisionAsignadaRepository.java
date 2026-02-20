package edu.examen.misionEstelar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.examen.misionEstelar.model.entities.MisionAsignada;
import java.util.List;
import edu.examen.misionEstelar.model.enumerated.EstadoMision;


public interface MisionAsignadaRepository extends JpaRepository<MisionAsignada, Long> {
    public List<MisionAsignada> findByEstadoMision(EstadoMision estadoMision);
}
