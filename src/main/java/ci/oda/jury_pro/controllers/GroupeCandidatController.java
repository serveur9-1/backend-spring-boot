package ci.oda.jury_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ci.oda.jury_pro.entites.Groupe_candidats;
import ci.oda.jury_pro.services.GroupeCandidatsService;

@RestController
public class GroupeCandidatController {
    @Autowired
    private GroupeCandidatsService groupeCandidatsService;

    @GetMapping("/groupe_candidats")
    public List<Groupe_candidats> getAllGroupeCandidats() {

        return groupeCandidatsService.getAllGroupeCandidats();

    }

    @GetMapping("/groupe_candidat/{groupeCandidatID}")
    public Groupe_candidats getGroupeCandidatById(@PathVariable Long groupeCandidatID) {

        return groupeCandidatsService.getGroupeCandidatById(groupeCandidatID);
    }

    @PostMapping("/groupe_candidat")
    public ResponseEntity<?> createOrUpdateGroupeCandidat(@RequestBody Groupe_candidats groupe_candidats) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!groupeCandidatsService.createOrUpdateGroupeCandidat(groupe_candidats)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/groupe_candidat/{groupeCandidatID}")
    public ResponseEntity<?> delete(@PathVariable Long groupeCandidatID) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            groupeCandidatsService.deleteGroupeCandidat(groupeCandidatID);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}
