package edu.examen.misionEstelar.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.examen.misionEstelar.model.entities.Nave;
import edu.examen.misionEstelar.service.NaveService;

@Controller
@RequestMapping("/naves")
public class NaveWebController {

    private final NaveService naveService;

    public NaveWebController(NaveService naveService) {
        this.naveService = naveService;
    }

    @GetMapping
    public String getAllNaves(Model model) {
        model.addAttribute("naves", naveService.getAllNaves());
        return "naves";
    }

    @GetMapping("/newNave")
    public String createNaveForm(Model model) {
        model.addAttribute("nave", new Nave());
        return "formularioNaves";
    }

    @PostMapping("/newNave")
    public String saveNewNave(@ModelAttribute Nave nave) {
        naveService.updateNave(nave);
        return "redirect:/naves";
    }
}
