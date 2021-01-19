package ci.oda.jury_pro.entites;

import javax.persistence.*;

@Entity
@Table(name = "vote_groupes")
public class vote_groupes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteGroupeId;

    @ManyToOne
    private Jury jury;

    @ManyToOne
    private Criteres critere;

    @ManyToOne
    private Evenement evenement;

    @ManyToOne
    private Groupes groupe;

    private int note;
    private String commentaire;

    public Long getVoteGroupeId() {
        return this.voteGroupeId;
    }

    public void setVoteGroupeId(Long voteGroupeId) {
        this.voteGroupeId = voteGroupeId;
    }

    public Jury getJury() {
        return this.jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public Criteres getCritere() {
        return this.critere;
    }

    public void setCritere(Criteres critere) {
        this.critere = critere;
    }

    public Evenement getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Groupes getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupes groupe) {
        this.groupe = groupe;
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
