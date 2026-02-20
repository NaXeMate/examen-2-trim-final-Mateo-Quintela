package edu.examen.misionEstelar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.examen.misionEstelar.model.entities.Nave;
import edu.examen.misionEstelar.repositories.NaveRepository;

@Service
@Transactional
public class NaveService {

    private final NaveRepository naveRepo;

    public NaveService(NaveRepository naveRepo) {
        this.naveRepo = naveRepo;
    }

    @Transactional(readOnly = true)
    public List<Nave> getAllNaves() {
        return naveRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Nave getNaveById(Long id) {
        return naveRepo.findById(id).orElseThrow();
    }

    public Nave updateNave(Nave nave) {
        if (!naveRepo.existsById(nave.getId())) {
            nave.setId(null);
            return naveRepo.save(nave);
        } else if (naveRepo.existsById(nave.getId())) {
            return naveRepo.save(nave);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteNaveById(Long id) {
        if (!naveRepo.existsById(id)) {
            throw new IllegalArgumentException("No existe ninguna nave con este ID.");
        }

        naveRepo.deleteById(id);
    }
}
