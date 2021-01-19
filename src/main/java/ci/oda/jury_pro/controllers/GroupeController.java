package ci.oda.jury_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ci.oda.jury_pro.entites.Groupes;
import ci.oda.jury_pro.services.GroupesService;

@RestController
public class GroupeController {
    @Autowired
    private GroupesService groupesService;

    @GetMapping("/groupes")
    public List<Groupes> getAllGroupes() {

        return groupesService.getAllGroupes();

    }

    @GetMapping("/groupe/{groupeId}")
    public Groupes getEvenementById(@PathVariable Long groupeId) {

        return groupesService.getGroupeById(groupeId);
    }

    @PostMapping("/groupe")
    public ResponseEntity<?> createOrUpdateGroupe(@RequestBody Groupes groupes) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!groupesService.createOrUpdateGroupe(groupes)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/groupe/{groupeId}")
    public ResponseEntity<?> delete(@PathVariable Long groupeId) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            groupesService.deleteGroupe(groupeId);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
