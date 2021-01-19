package ci.oda.jury_pro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.oda.jury_pro.entites.Evenement;

public interface EvenementsRepository extends JpaRepository<Evenement, Long> {

}
