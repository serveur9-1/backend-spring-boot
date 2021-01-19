package ci.oda.jury_pro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.oda.jury_pro.entites.Criteres;
import ci.oda.jury_pro.repositories.CriteresRepository;

@Service
public class CriteresService {
    @Autowired
    private CriteresRepository criteresRepository;

    public List<Criteres> getAllCriteres() {

        return criteresRepository.findAll();

    }

    public Criteres getCritereById(Long candidatId) {

        Optional<Criteres> item = criteresRepository.findById(candidatId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateCritere(Criteres criteres) {

        Boolean result = false;

        try {

            if (criteres.getCritereId() < 0) {
                Criteres item = criteresRepository.getOne(criteres.getCritereId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    criteresRepository.save(criteres);
                }

            } else if (criteres.getCritereId() > 0) {
                criteresRepository.save(criteres);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteCritere(Long critereId) {

        Boolean result = false;
        try {

            if (critereId <= 0) {
                throw new Exception();
            }
            criteresRepository.deleteById(critereId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
