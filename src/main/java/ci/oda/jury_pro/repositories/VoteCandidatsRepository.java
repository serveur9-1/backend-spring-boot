package ci.oda.jury_pro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.oda.jury_pro.entites.vote_candidats;

public interface VoteCandidatsRepository extends JpaRepository<vote_candidats, Long> {

}
