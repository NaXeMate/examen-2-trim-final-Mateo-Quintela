package edu.examen.misionEstelar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.examen.misionEstelar.model.entities.Persona;
import edu.examen.misionEstelar.repositories.PersonaRepository;

@Service
@Transactional
public class PersonaService {

    private final PersonaRepository personaRepo;

    public PersonaService(PersonaRepository personaRepo) {
        this.personaRepo = personaRepo;
    }

    @Transactional(readOnly = true)
    public List<Persona> getAllPersonas() {
        return personaRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Persona getPersonaById(Long id) {
        return personaRepo.findById(id).orElseThrow();
    }

    public Persona updatePersona(Persona persona) {
        if (!personaRepo.existsById(persona.getId())) {
            persona.setId(null);
            return personaRepo.save(persona);
        } else if (personaRepo.existsById(persona.getId())) {
            return personaRepo.save(persona);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deletePersonaById(Long id) {
        if (!personaRepo.existsById(id)) {
            throw new IllegalArgumentException("No hay una persona con este ID");
        }
        personaRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Persona getPersonaByLicenciaEstelar(String licenciaEstelar) {
        return personaRepo.findByLicenciaEstelar(licenciaEstelar);
    }
}
