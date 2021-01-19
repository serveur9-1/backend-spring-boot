package ci.oda.jury_pro.entites;

import javax.persistence.*;

@Entity
@Table(name = "vote_candidats")
public class vote_candidats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteCandidatId;

    @ManyToOne
    private Jury jury;

    @ManyToOne
    private Evenement evenement;

    @ManyToOne
    private Candidats candidat;

    private int note;
    private String commentaire;

    public Long getVoteCandidatId() {
        return this.voteCandidatId;
    }

    public void setVoteCandidatId(Long voteCandidatId) {
        this.voteCandidatId = voteCandidatId;
    }

    public Jury getJury() {
        return this.jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public Evenement getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Candidats getCandidat() {
        return this.candidat;
    }

    public void setCandidat(Candidats candidat) {
        this.candidat = candidat;
    }

    public int getNote() {
        return this.note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

}
