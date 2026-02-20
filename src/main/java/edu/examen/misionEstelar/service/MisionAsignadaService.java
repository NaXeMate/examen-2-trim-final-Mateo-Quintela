package edu.examen.misionEstelar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.examen.misionEstelar.model.entities.MisionAsignada;
import edu.examen.misionEstelar.model.enumerated.EstadoMision;
import edu.examen.misionEstelar.repositories.MisionAsignadaRepository;

@Service
@Transactional
public class MisionAsignadaService {

    private final MisionAsignadaRepository maRepo;

    public MisionAsignadaService(MisionAsignadaRepository maRepo) {
        this.maRepo = maRepo;
    }

    @Transactional(readOnly = true)
    public List<MisionAsignada> getAllMisiones() {
        return maRepo.findAll();
    } 

    @Transactional(readOnly = true)
    public MisionAsignada getMisionById(Long id) {
        return maRepo.findById(id).orElseThrow();
    }

    public MisionAsignada updateMisionAsignada(MisionAsignada mision) {
        if (!maRepo.existsById(mision.getId())) {
            mision.setId(null);
            return maRepo.save(mision);
        } else if (maRepo.existsById(mision.getId())) {
            return maRepo.save(mision);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteMisionById(Long id) {
        if (!maRepo.existsById(id)) {
            throw new IllegalArgumentException("No existe ninguna misión con ese ID.");
        }

        maRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<MisionAsignada> getMisionesByEstado(EstadoMision estadoMision) {
        return maRepo.findByEstadoMision(estadoMision);
    }
}
