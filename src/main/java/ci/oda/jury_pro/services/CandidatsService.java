package ci.oda.jury_pro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.oda.jury_pro.entites.Candidats;
import ci.oda.jury_pro.repositories.CandidtatsRepository;

@Service
public class CandidatsService {
    @Autowired
    private CandidtatsRepository candidtatsRepository;

    public List<Candidats> getAllCandidats() {

        return candidtatsRepository.findAll();

    }

    public Candidats getCandidatById(Long candidatId) {

        Optional<Candidats> item = candidtatsRepository.findById(candidatId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateCandidat(Candidats candidat) {

        Boolean result = false;

        try {

            if (candidat.getCandidatId() < 0) {
                Candidats item = candidtatsRepository.getOne(candidat.getCandidatId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    candidtatsRepository.save(candidat);
                }

            } else if (candidat.getCandidatId() > 0) {
                candidtatsRepository.save(candidat);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteCandidat(Long candidatId) {

        Boolean result = false;
        try {

            if (candidatId <= 0) {
                throw new Exception();
            }
            candidtatsRepository.deleteById(candidatId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

}
