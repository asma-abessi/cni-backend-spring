package com.cniback.cniback.controller;


import com.cniback.cniback.dao.PointageRepository;
import com.cniback.cniback.modele. Pointage;
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
public class PointageController {
    @Autowired
    PointageRepository PointageRepository;

    @GetMapping(value="/allPointage")
    public List<Pointage> allPointage(){
        return PointageRepository.findAll();
    }

    @PostMapping(value="/addPointage")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Pointage addAvance(@Valid @RequestBody Pointage p){
        return PointageRepository.save(p);
    }

    @GetMapping(value="/Pointage/{id}")
    public ResponseEntity<Pointage> getPointage(@PathVariable Integer id) throws Exception{
    	Pointage p = PointageRepository.findById(id).orElseThrow(()->new Exception("La Pointage n'existe pas"));
        return ResponseEntity.ok().body(p);
    }

    @PutMapping(value="/Pointage/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public ResponseEntity<Pointage> updatePointage(@PathVariable Integer id,@Valid @RequestBody Pointage catDetails) throws Exception{
    	Pointage p = PointageRepository.findById(id).orElseThrow(()->new Exception("La Pointage n'existe pas"));
        p.setPresent(p.getPresent());
        Pointage updatep =PointageRepository.save(p);
        return ResponseEntity.ok(updatep);
    }

    @DeleteMapping(value="/Pointage/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Map<String,Boolean> deletePointage(@PathVariable Integer id) throws Exception {
    	Pointage p = PointageRepository.findById(id).orElseThrow(()->new Exception("La Pointage n'existe pas"));
    	PointageRepository.delete(p);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Pointage est supprimé!",Boolean.TRUE);
        return response;
    }
}
