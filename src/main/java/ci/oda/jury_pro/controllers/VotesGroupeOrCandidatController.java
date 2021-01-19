package ci.oda.jury_pro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ci.oda.jury_pro.entites.vote_groupes;
import ci.oda.jury_pro.entites.vote_candidats;
import ci.oda.jury_pro.services.VoteGroupeOrCandidatServices;

@RestController
public class VotesGroupeOrCandidatController {
    @Autowired
    private VoteGroupeOrCandidatServices voteGroupeOrCandidatServices;

    @GetMapping("/vote_candidats")
    public List<vote_candidats> getAllVoteCandidats() {

        return voteGroupeOrCandidatServices.getAllVotesCandidats();

    }

    @GetMapping("/vote_candidat/{voteCandidatID}")
    public vote_candidats getVoteCandidatById(@PathVariable Long voteCandidatID) {

        return voteGroupeOrCandidatServices.getVoteCandidatById(voteCandidatID);
    }

    @PostMapping("/vote_candidat")
    public ResponseEntity<?> createOrUpdateVoteCandidat(@RequestBody vote_candidats vote_candidats) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!voteGroupeOrCandidatServices.createOrUpdateVoteCandidat(vote_candidats)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/vote_candidat/{voteCandidatID}")
    public ResponseEntity<?> deleteCandidat(@PathVariable Long voteCandidatID) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            voteGroupeOrCandidatServices.deleteVoteCandidat(voteCandidatID);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    /* CRUD TO GROUPE */

    @GetMapping("/vote_groupes")
    public List<vote_groupes> getAllVoteGroupes() {

        return voteGroupeOrCandidatServices.getAllVotesGroupes();

    }

    @GetMapping("/vote_groupe/{voteGroupeID}")
    public vote_groupes getVoteGroupeById(@PathVariable Long voteGroupeID) {

        return voteGroupeOrCandidatServices.getVoteGroupesById(voteGroupeID);
    }

    @PostMapping("/vote_groupe")
    public ResponseEntity<?> createOrUpdateVoteGroupe(@RequestBody vote_groupes vote_groupes) {

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            if (!voteGroupeOrCandidatServices.createOrUpdateVoteGroupe(vote_groupes)) {
                throw new Exception();
            }

            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @DeleteMapping("/vote_groupe/{voteGroupeID}")
    public ResponseEntity<?> deleteGroupe(@PathVariable Long voteGroupeID) {
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {

            voteGroupeOrCandidatServices.deleteVoteGroupe(voteGroupeID);
            result = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

}
