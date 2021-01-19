package ci.oda.jury_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ci.oda.jury_pro.entites.Jury;
import ci.oda.jury_pro.services.JuryService;

@RestController
public class JuryController {

    @Autowired
    private JuryService juryService;

    @GetMapping("/juries")
    public List<Jury> getAllJuries() {

        return juryService.getAllJuries();

    }

    @GetMapping("/jury/{juryId}")
    public Jury getJuryById(@PathVariable Long juryId) {

        return juryService.getJuryById(juryId);
    }

    @PostMapping("/jury")
    public ResponseEntity<?> createOrUpdateJury(@RequestBody Jury jury) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!juryService.createOrUpdateJury(jury)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/jury/{juryId}")
    public ResponseEntity<?> delete(@PathVariable Long juryId) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            juryService.deleteJury(juryId);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
