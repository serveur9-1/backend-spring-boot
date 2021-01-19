package ci.oda.jury_pro.entites;

import javax.persistence.*;

@Entity
@Table(name = "jury")
public class Jury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long juryId;
    private String juryCode;
    private String juryNomComplet;
    private String juryEmail;
    private String juryTelephone;
    @ManyToOne
    private Evenement evenement;

    public Long getJuryId() {
        return this.juryId;
    }

    public void setJuryId(Long juryId) {
        this.juryId = juryId;
    }

    public String getJuryCode() {
        return this.juryCode;
    }

    public void setJuryCode(String juryCode) {
        this.juryCode = juryCode;
    }

    public String getJuryNomComplet() {
        return this.juryNomComplet;
    }

    public void setJuryNomComplet(String juryNomComplet) {
        this.juryNomComplet = juryNomComplet;
    }

    public String getJuryEmail() {
        return this.juryEmail;
    }

    public void setJuryEmail(String juryEmail) {
        this.juryEmail = juryEmail;
    }

    public String getJuryTelephone() {
        return this.juryTelephone;
    }

    public void setJuryTelephone(String juryTelephone) {
        this.juryTelephone = juryTelephone;
    }

    public Evenement getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}
