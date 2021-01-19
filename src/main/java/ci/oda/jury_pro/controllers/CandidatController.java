package ci.oda.jury_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ci.oda.jury_pro.entites.Candidats;
import ci.oda.jury_pro.services.CandidatsService;

@RestController
public class CandidatController {
    @Autowired
    private CandidatsService candidatsService;

    @GetMapping("/candidats")
    public List<Candidats> getAllCandidats() {

        return candidatsService.getAllCandidats();

    }

    @GetMapping("/candidat/{candidatId}")
    public Candidats getCandidatById(@PathVariable Long candidatId) {

        return candidatsService.getCandidatById(candidatId);
    }

    @PostMapping("/candidats")
    public ResponseEntity<?> createOrUpdateCandidat(@RequestBody Candidats candidats) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!candidatsService.createOrUpdateCandidat(candidats)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/candidat/{candidatId}")
    public ResponseEntity<?> delete(@PathVariable Long candidatId) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            candidatsService.deleteCandidat(candidatId);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}
