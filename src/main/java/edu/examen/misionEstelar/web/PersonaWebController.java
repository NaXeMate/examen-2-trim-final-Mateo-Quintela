package edu.examen.misionEstelar.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.examen.misionEstelar.model.entities.Persona;
import edu.examen.misionEstelar.service.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaWebController {

    private final PersonaService personaService;

    public PersonaWebController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public String getAllpersonas(Model model) {
        model.addAttribute("personas", personaService.getAllPersonas());
        return "personas";
    }

    @GetMapping("/new")
    public String createpersonaForm(Model model) {
        model.addAttribute("persona", new Persona());
        return "formulario";
    }

    @PostMapping("/new")
    public String saveNewpersona(@ModelAttribute Persona persona) {
        personaService.updatePersona(persona);
        return "redirect:/personas";
    }
}
