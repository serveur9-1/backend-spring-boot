package ci.oda.jury_pro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.oda.jury_pro.entites.Jury;
import ci.oda.jury_pro.repositories.JuryRepository;

@Service
public class JuryService {
    @Autowired
    private JuryRepository juryRepository;

    public List<Jury> getAllJuries() {

        return juryRepository.findAll();

    }

    public Jury getJuryById(Long juryId) {
        Optional<Jury> item = juryRepository.findById(juryId);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Boolean createOrUpdateJury(Jury jury) {

        Boolean result = false;

        try {
            if (jury.getJuryId() < 0) {
                Jury item = juryRepository.getOne(jury.getJuryId());
                if (item == null) {
                    result = false;
                    throw new Exception();
                } else {
                    juryRepository.save(jury);
                }

            } else if (jury.getJuryId() > 0) {
                juryRepository.save(jury);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public boolean deleteJury(Long juryId) {

        Boolean result = false;
        try {

            if (juryId == 0) {
                throw new Exception();
            }
            juryRepository.deleteById(juryId);

            result = true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
