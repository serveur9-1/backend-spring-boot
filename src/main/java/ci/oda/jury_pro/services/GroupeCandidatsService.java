package ci.oda.jury_pro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.oda.jury_pro.entites.Groupe_candidats;
import ci.oda.jury_pro.repositories.GroupesCandidatsRepository;

@Service
public class GroupeCandidatsService {
    @Autowired
    private GroupesCandidatsRepository groupesCandidatsRepository;

    public List<Groupe_candidats> getAllGroupeCandidats() {

        return groupesCandidatsRepository.findAll();

    }

    public Groupe_candidats getGroupeCandidatById(Long groupeCandidatId) {

        Optional<Groupe_candidats> item = groupesCandidatsRepository.findById(groupeCandidatId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateGroupeCandidat(Groupe_candidats groupe_candidats) {

        Boolean result = false;

        try {
            if (groupe_candidats.getGroupeCandidatId() < 0) {
                Groupe_candidats item = groupesCandidatsRepository.getOne(groupe_candidats.getGroupeCandidatId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    groupesCandidatsRepository.save(groupe_candidats);
                }

            } else if (groupe_candidats.getGroupeCandidatId() > 0) {
                groupesCandidatsRepository.save(groupe_candidats);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteGroupeCandidat(Long groupeCandidatId) {

        Boolean result = false;
        try {

            if (groupeCandidatId == 0) {
                throw new Exception();
            }
            groupesCandidatsRepository.deleteById(groupeCandidatId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
