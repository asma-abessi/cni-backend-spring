package com.cniback.cniback.controller;

import com.cniback.cniback.dao.EmployeRepository;
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
public class EmployeController {
    @Autowired
    EmployeRepository EmployeRepository;

    @GetMapping(value="/allEmploye")
    public List<Employe> allEmploye(){
        return EmployeRepository.findAll();
    }

    @PostMapping(value="/addEmploye")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Employe addEmploye(@Valid @RequestBody Employe e){
        return EmployeRepository.save(e);
    }

    @GetMapping(value="/Employe/{id}")
    public ResponseEntity<Employe> getEmploye(@PathVariable Integer id) throws Exception{
    	Employe e = EmployeRepository.findById(id).orElseThrow(()->new Exception("LEmploye n'existe pas"));
        return ResponseEntity.ok().body(e);
    }

    @PutMapping(value="/Employe/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Integer id,@Valid @RequestBody Employe ep) throws Exception{
    	Employe e = EmployeRepository.findById(id).orElseThrow(()->new Exception("L Employe n'existe pas"));
    	e.setNom(e.getNom());
        Employe updatee = EmployeRepository.save(e);
        return ResponseEntity.ok(updatee);
    }

    @DeleteMapping(value="/Employe/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Map<String,Boolean> deleteEmploye(@PathVariable Integer id) throws Exception {
    	Employe e = EmployeRepository.findById(id).orElseThrow(()->new Exception("L Employe n'existe pas"));
    	EmployeRepository.delete(e);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Employe est supprimé!",Boolean.TRUE);
        return response;
    }
}
