package ci.oda.jury_pro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.oda.jury_pro.entites.Evenement;
import ci.oda.jury_pro.repositories.EvenementsRepository;

@Service
public class EvenementsService {
    @Autowired
    private EvenementsRepository evenementsRepository;

    public List<Evenement> getAllEvenements() {

        return evenementsRepository.findAll();

    }

    public Evenement getEvenementById(Long evenementId) {
        Optional<Evenement> item = evenementsRepository.findById(evenementId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateEvenement(Evenement evenement) {

        Boolean result = false;

        try {
            if (evenement.getEvenementId() < 0) {
                Evenement item = evenementsRepository.getOne(evenement.getEvenementId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    evenementsRepository.save(evenement);
                }

            } else if (evenement.getEvenementId() > 0) {
                evenementsRepository.save(evenement);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteEvenement(Long evenementId) {

        Boolean result = false;
        try {

            if (evenementId == 0) {
                throw new Exception();
            }
            evenementsRepository.deleteById(evenementId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

}
