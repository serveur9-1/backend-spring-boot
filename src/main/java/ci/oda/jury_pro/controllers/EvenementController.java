package ci.oda.jury_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ci.oda.jury_pro.entites.Evenement;
import ci.oda.jury_pro.services.EvenementsService;

@RestController
public class EvenementController {

    @Autowired
    private EvenementsService evenementsService;

    @GetMapping("/evenements")
    public List<Evenement> getAllEvenements() {

        return evenementsService.getAllEvenements();

    }

    @GetMapping("/evenement/{evenementId}")
    public Evenement getEvenementById(@PathVariable Long evenementId) {

        return evenementsService.getEvenementById(evenementId);
    }

    @PostMapping("/evenements")
    public ResponseEntity<?> createOrUpdateEvenement(@RequestBody Evenement evenement) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!evenementsService.createOrUpdateEvenement(evenement)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/evenement/{evenementId}")
    public ResponseEntity<?> delete(@PathVariable Long evenementId) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            evenementsService.deleteEvenement(evenementId);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
