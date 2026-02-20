package edu.examen.misionEstelar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.examen.misionEstelar.model.entities.Tripulante;
import edu.examen.misionEstelar.repositories.TripulanteRepository;

@Service
@Transactional
public class TripulanteService {

    private final TripulanteRepository tripulanteRepo;

    public TripulanteService(TripulanteRepository tripulanteRepo) {
        this.tripulanteRepo = tripulanteRepo;
    }

    @Transactional(readOnly = true)
    public List<Tripulante> getAllTripulantes() {
        return tripulanteRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Tripulante getTripulanteById(Long id) {
        return tripulanteRepo.findById(id).orElseThrow();
    }

    public Tripulante updateTripulante(Tripulante tripulante) {
        if (!tripulanteRepo.existsById(tripulante.getId())) {
            tripulante.setId(null);
            return tripulanteRepo.save(tripulante);
        } else if (tripulanteRepo.existsById(tripulante.getId())) {
            return tripulanteRepo.save(tripulante);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteTripulanteById(Long id) {
        if (!tripulanteRepo.existsById(id)) {
            throw new IllegalArgumentException("No hay una tripulante con este ID");
        }
        tripulanteRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Tripulante getTripulanteByLicenciaEstelar(String licenciaEstelar) {
        return tripulanteRepo.findByLicenciaEstelar(licenciaEstelar);
    }
}
