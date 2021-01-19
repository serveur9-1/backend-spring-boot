package ci.oda.jury_pro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.oda.jury_pro.entites.Groupes;
import ci.oda.jury_pro.repositories.GroupesRepository;

@Service
public class GroupesService {
    @Autowired
    private GroupesRepository groupesRepository;

    public List<Groupes> getAllGroupes() {

        return groupesRepository.findAll();

    }

    public Groupes getGroupeById(Long groupeId) {
        Optional<Groupes> item = groupesRepository.findById(groupeId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateGroupe(Groupes groupes) {

        Boolean result = false;

        try {
            if (groupes.getGroupeId() < 0) {
                Groupes item = groupesRepository.getOne(groupes.getGroupeId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    groupesRepository.save(groupes);
                }

            } else if (groupes.getGroupeId() > 0) {
                groupesRepository.save(groupes);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteGroupe(Long groupeId) {

        Boolean result = false;
        try {

            if (groupeId == 0) {
                throw new Exception();
            }
            groupesRepository.deleteById(groupeId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
