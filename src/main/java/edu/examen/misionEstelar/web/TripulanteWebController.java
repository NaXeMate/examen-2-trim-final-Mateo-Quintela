package edu.examen.misionEstelar.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.examen.misionEstelar.model.entities.Tripulante;
import edu.examen.misionEstelar.service.TripulanteService;

@Controller
@RequestMapping("/tripulantes")
public class TripulanteWebController {

    private final TripulanteService tripulanteService;

    public TripulanteWebController(TripulanteService tripulanteService) {
        this.tripulanteService = tripulanteService;
    }

    @GetMapping
    public String getAllTripulantes(Model model) {
        model.addAttribute("tripulantes", tripulanteService.getAllTripulantes());
        return "tripulantes";
    }

    @GetMapping("/newTripulante")
    public String createTripulanteForm(Model model) {
        model.addAttribute("tripulante", new Tripulante());
        return "formularioTripulantes";
    }

    @PostMapping("/newTripulante")
    public String saveNewTripulante(@ModelAttribute Tripulante tripulante) {
        tripulanteService.updateTripulante(tripulante);
        return "redirect:/tripulantes";
    }
}
