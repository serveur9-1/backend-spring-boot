package ci.oda.jury_pro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.oda.jury_pro.entites.Jury;

public interface JuryRepository extends JpaRepository<Jury, Long> {

}
