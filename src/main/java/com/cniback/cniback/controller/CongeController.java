package com.cniback.cniback.controller;

import com.cniback.cniback.dao.CongeRepository;
import com.cniback.cniback.modele.Conge;
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
public class CongeController {
    @Autowired
    CongeRepository CongeRepository;

    @GetMapping(value="/allConge")
    public List<Conge> allConge(){
        return CongeRepository.findAll();
    }

    @PostMapping(value="/addConge")
   // @PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Conge addConge(@Valid @RequestBody Conge c){
        return CongeRepository.save(c);
    }

    @GetMapping(value="/Conge/{id}")
    public ResponseEntity<Conge> getCategorie(@PathVariable Integer id) throws Exception{
    	Conge c = CongeRepository.findById(id).orElseThrow(()->new Exception("La Conge n'existe pas"));
        return ResponseEntity.ok().body(c);
    }

    @PutMapping(value="/Conge/{id}")
   // @PreAuthorize("hasRole('admin') or hasRole('pm')")
    public ResponseEntity<Conge> updateConge(@PathVariable Integer id,@Valid @RequestBody Conge catDetails) throws Exception{
    	Conge c = CongeRepository.findById(id).orElseThrow(()->new Exception("La Conge n'existe pas"));
    	c.setDatedeb(c.getDatedeb());
       Conge updatec = CongeRepository.save(c);
        return ResponseEntity.ok(updatec);
    }

    @DeleteMapping(value="/Conge/{id}")
   // @PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Map<String,Boolean> deleteConge(@PathVariable Integer id) throws Exception {
    	Conge c = CongeRepository.findById(id).orElseThrow(()->new Exception("La catégorie n'existe pas"));
    	CongeRepository.delete(c);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Conge est supprimé!",Boolean.TRUE);
        return response;
    }
}
