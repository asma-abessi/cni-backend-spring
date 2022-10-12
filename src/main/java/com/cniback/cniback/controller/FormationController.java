package com.cniback.cniback.controller;

import com.cniback.cniback.dao.FormationRepository;
import com.cniback.cniback.modele.Formation;

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
public class FormationController {
    @Autowired
    FormationRepository FormationRepository;

    @GetMapping(value="/allFormation")
    public List<Formation> allFormation(){
        return FormationRepository.findAll();
    }

    @PostMapping(value="/addFormation")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Formation addCategorie(@Valid @RequestBody Formation f){
        return FormationRepository.save(f);
    }

    @GetMapping(value="/Formation/{id}")
    public ResponseEntity<Formation> getFormation(@PathVariable Integer id) throws Exception{
    	Formation f = FormationRepository.findById(id).orElseThrow(()->new Exception("La Formation n'existe pas"));
        return ResponseEntity.ok().body(f);
    }

    @PutMapping(value="/Formation/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public ResponseEntity<Formation> updateFormation(@PathVariable Integer id,@Valid @RequestBody Formation catDetails) throws Exception{
    	Formation f =FormationRepository.findById(id).orElseThrow(()->new Exception("La formtion n'existe pas"));
        f.setTheme(catDetails.getTheme());
        Formation updatef = FormationRepository.save(f);
        return ResponseEntity.ok(updatef);
    }

    @DeleteMapping(value="/Formation/{id}")
    //@PreAuthorize("hasRole('admin') or hasRole('pm')")
    public Map<String,Boolean> deleteFormation(@PathVariable Integer id) throws Exception {
    	Formation f = FormationRepository.findById(id).orElseThrow(()->new Exception("La Formation n'existe pas"));
        FormationRepository.delete(f);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Formation est supprimé!",Boolean.TRUE);
        return response;
    }
}
