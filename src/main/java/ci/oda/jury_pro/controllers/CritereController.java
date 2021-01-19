package ci.oda.jury_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ci.oda.jury_pro.entites.Criteres;
import ci.oda.jury_pro.services.CriteresService;

@RestController
public class CritereController {
    @Autowired
    private CriteresService criteresService;

    @GetMapping("/criteres")
    public List<Criteres> getAllCriteres() {

        return criteresService.getAllCriteres();

    }

    @GetMapping("/critere/{critereId}")
    public Criteres getCritereById(@PathVariable Long critereId) {

        return criteresService.getCritereById(critereId);
    }

    @PostMapping("/criteres")
    public ResponseEntity<?> createOrUpdateCritere(@RequestBody Criteres criteres) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!criteresService.createOrUpdateCritere(criteres)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/critere/{critereId}")
    public ResponseEntity<?> delete(@PathVariable Long critereId) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            criteresService.deleteCritere(critereId);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
