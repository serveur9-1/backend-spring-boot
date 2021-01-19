package ci.oda.jury_pro.entites;

import javax.persistence.*;

@Entity
@Table(name = "groupe_candidats")
public class Groupe_candidats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupeCandidatId;

    @ManyToOne
    private Groupes groupe;

    @ManyToOne
    private Candidats candidat;

    public Long getGroupeCandidatId() {
        return this.groupeCandidatId;
    }

    public void setGroupeCandidatId(Long groupeCandidatId) {
        this.groupeCandidatId = groupeCandidatId;
    }

    public Groupes getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupes groupe) {
        this.groupe = groupe;
    }

    public Candidats getCandidat() {
        return this.candidat;
    }

    public void setCandidat(Candidats candidat) {
        this.candidat = candidat;
    }

}
