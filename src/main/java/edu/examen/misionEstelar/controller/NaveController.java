package edu.examen.misionEstelar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.examen.misionEstelar.model.entities.Nave;
import edu.examen.misionEstelar.service.NaveService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/naves")
public class NaveController {

    private final NaveService naveService;

    public NaveController(NaveService naveService) {
        this.naveService = naveService;
    }

    @GetMapping
    public ResponseEntity<List<Nave>> getAllNaves() {
        List<Nave> naves = naveService.getAllNaves();
        return ResponseEntity.ok(naves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nave> getNaveById(@PathVariable Long id) {
        Nave nave = naveService.getNaveById(id);
        return ResponseEntity.ok(nave);
    }

    @PostMapping
    public ResponseEntity<Nave> createNave(@RequestBody Nave nave) {
        nave.setId(null);
        
        Nave nuevaNave = naveService.updateNave(nave);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNave);
    }

     @PutMapping("/{id}")
     public ResponseEntity<Nave> updateNave(@PathVariable Long id, @RequestBody Nave nave) {
        nave.setId(id);
        
        Nave naveActualizada = naveService.updateNave(nave);
        
         return ResponseEntity.ok(naveActualizada);
     }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNaveById(@PathVariable Long id) {
        naveService.deleteNaveById(id);

        return ResponseEntity.noContent().build();
    }
}
