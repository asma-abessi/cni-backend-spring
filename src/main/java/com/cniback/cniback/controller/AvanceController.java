package com.cniback.cniback.controller;

import com.cniback.cniback.dao.AvanceRepository;
import com.cniback.cniback.modele. Avance;
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
public class AvanceController {
    @Autowired
    AvanceRepository AvanceRepository;

    @GetMapping(value="/allAvance")
    public List<Avance> allAvance(){
        return AvanceRepository.findAll();
    }

    @PostMapping(value="/addAvance")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Avance addAvance(@Valid @RequestBody Avance a){
        return AvanceRepository.save(a);
    }

    @GetMapping(value="/Avance/{id}")
    public ResponseEntity<Avance> getAvance(@PathVariable Integer id) throws Exception{
    	Avance av = AvanceRepository.findById(id).orElseThrow(()->new Exception("La Avance n'existe pas"));
        return ResponseEntity.ok().body(av);
    }

    @PutMapping(value="/Avance/{id}")
   //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public ResponseEntity<Avance> updateAvance(@PathVariable Integer id,@Valid @RequestBody Avance catDetails) throws Exception{
    	Avance av = AvanceRepository.findById(id).orElseThrow(()->new Exception("La Avance n'existe pas"));
        av.setmontant(av.getmontant());
        Avance updateav = AvanceRepository.save(av);
        return ResponseEntity.ok(updateav);
    }

    @DeleteMapping(value="/Avance/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Map<String,Boolean> deleteAvance(@PathVariable Integer id) throws Exception {
    	Avance av = AvanceRepository.findById(id).orElseThrow(()->new Exception("La Avance n'existe pas"));
        AvanceRepository.delete(av);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Avance est supprimé!",Boolean.TRUE);
        return response;
    }
}
