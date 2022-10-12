package com.cniback.cniback.controller;

import com.cniback.cniback.dao.SuperviseurRepository;
import com.cniback.cniback.modele.Superviseur;

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
public class SuperviseurController {
    @Autowired
    SuperviseurRepository SuperviseurRepository;

    @GetMapping(value="/allSuperviseur")
    public List<Superviseur> allSuperviseur(){
        return SuperviseurRepository.findAll();
    }

    @PostMapping(value="/addSuperviseur")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Superviseur addCategorie(@Valid @RequestBody Superviseur s){
        return SuperviseurRepository.save(s);
    }

    @GetMapping(value="/Superviseur/{id}")
    public ResponseEntity<Superviseur> getSuperviseur(@PathVariable Integer id) throws Exception{
    	Superviseur s = SuperviseurRepository.findById(id).orElseThrow(()->new Exception("L Superviseur n'existe pas"));
        return ResponseEntity.ok().body(s);
    }

    @PutMapping(value="/Superviseur/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public ResponseEntity<Superviseur> updateSuperviseur(@PathVariable Integer id,@Valid @RequestBody Superviseur spe) throws Exception{
    	Superviseur sp = SuperviseurRepository.findById(id).orElseThrow(()->new Exception("La Superviseur n'existe pas"));
       sp.setNom(spe.getNom());
        Superviseur updatesp = SuperviseurRepository.save(sp);
        return ResponseEntity.ok(updatesp);
    }

    @DeleteMapping(value="/Superviseur/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Map<String,Boolean> deleteSuperviseur(@PathVariable Integer id) throws Exception {
    	Superviseur sp = SuperviseurRepository.findById(id).orElseThrow(()->new Exception("La Superviseur n'existe pas"));
    	SuperviseurRepository.delete(sp);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Superviseur est supprimé!",Boolean.TRUE);
        return response;
    }
}
