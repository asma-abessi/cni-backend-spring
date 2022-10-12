package com.cniback.cniback.controller;

import com.cniback.cniback.dao.TacheRepository;
import com.cniback.cniback.modele. Tache;
import com.cniback.cniback.modele.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/auth/ghofran")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheController {
    @Autowired
    TacheRepository TacheRepository;

    @GetMapping(value="/allTache")
    public List<Tache> allTache(){
        return TacheRepository.findAll();
    }

    @PostMapping(value="/addTache")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Tache addTache(@Valid @RequestBody Tache t){
        return TacheRepository.save(t);
    }

    @GetMapping(value="/Tache/{id}")
    public ResponseEntity<Tache> getTache(@PathVariable Integer id) throws Exception{
    	Tache t = TacheRepository.findById(id).orElseThrow(()->new Exception("La Avance n'existe pas"));
        return ResponseEntity.ok().body(t);
    }

    @PutMapping(value="/Tache/{id}")
   // @PreAuthorize("hasRole('admin') or hasRole('pm')")
    public ResponseEntity<Tache> updateTache(@PathVariable Integer id,@Valid @RequestBody Tache catDetails) throws Exception{
    	Tache t = TacheRepository.findById(id).orElseThrow(()->new Exception("La Tache n'existe pas"));
       t.setTravail(t.getTravail());
        Tache updateav = TacheRepository.save(t);
        return ResponseEntity.ok(updateav);
    }

    @DeleteMapping(value="/Tache/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Map<String,Boolean> deleteCategorie(@PathVariable Integer id) throws Exception {
    	Tache t = TacheRepository.findById(id).orElseThrow(()->new Exception("La Avance n'existe pas"));
    	TacheRepository.delete(t);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Tache est supprimé!",Boolean.TRUE);
        return response;
    }
}
