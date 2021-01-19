package ci.oda.jury_pro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.oda.jury_pro.entites.vote_candidats;
import ci.oda.jury_pro.entites.vote_groupes;
import ci.oda.jury_pro.repositories.VoteCandidatsRepository;
import ci.oda.jury_pro.repositories.voteGroupesRepository;

@Service
public class VoteGroupeOrCandidatServices {
    @Autowired
    private VoteCandidatsRepository voteCandidatsRepository;

    public List<vote_candidats> getAllVotesCandidats() {

        return voteCandidatsRepository.findAll();

    }

    public vote_candidats getVoteCandidatById(Long voteCandidatId) {

        Optional<vote_candidats> item = voteCandidatsRepository.findById(voteCandidatId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateVoteCandidat(vote_candidats vote_candidats) {

        Boolean result = false;

        try {
            if (vote_candidats.getVoteCandidatId() <= 0) {
                vote_candidats item = voteCandidatsRepository.getOne(vote_candidats.getVoteCandidatId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    voteCandidatsRepository.save(vote_candidats);
                }

            } else if (vote_candidats.getVoteCandidatId() > 0) {
                voteCandidatsRepository.save(vote_candidats);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteVoteCandidat(Long voteCandidatId) {

        Boolean result = false;
        try {

            if (voteCandidatId <= 0) {
                throw new Exception();
            }
            voteCandidatsRepository.deleteById(voteCandidatId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    @Autowired
    private voteGroupesRepository voteGroupesRepository;

    public List<vote_groupes> getAllVotesGroupes() {

        return voteGroupesRepository.findAll();

    }

    public vote_groupes getVoteGroupesById(Long voteGroupeId) {

        Optional<vote_groupes> item = voteGroupesRepository.findById(voteGroupeId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateVoteGroupe(vote_groupes vote_groupes) {

        Boolean result = false;

        try {
            if (vote_groupes.getVoteGroupeId() < 0) {
                vote_groupes item = voteGroupesRepository.getOne(vote_groupes.getVoteGroupeId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    voteGroupesRepository.save(vote_groupes);
                }

            } else if (vote_groupes.getVoteGroupeId() > 0) {
                voteGroupesRepository.save(vote_groupes);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteVoteGroupe(Long voteGroupeId) {

        Boolean result = false;
        try {

            if (voteGroupeId <= 0) {
                throw new Exception();
            }
            voteGroupesRepository.deleteById(voteGroupeId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
