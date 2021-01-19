package ci.oda.jury_pro.entites;

import javax.persistence.*;

@Entity
@Table(name = "candidats")
public class Candidats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidatId;
    private String candidatCode;
    private String candidatNom;
    private String candidatPrenoms;
    @Lob
    private Byte[] candidatPhoto;
    private String candidatEmail;
    private String candidatTelephone;
    @ManyToOne
    private Evenement evenement;

    public Long getCandidatId() {
        return this.candidatId;
    }

    public void setCandidatId(Long candidatId) {
        this.candidatId = candidatId;
    }

    public String getCandidatCode() {
        return this.candidatCode;
    }

    public void setCandidatCode(String candidatCode) {
        this.candidatCode = candidatCode;
    }

    public String getCandidatNom() {
        return this.candidatNom;
    }

    public void setCandidatNom(String candidatNom) {
        this.candidatNom = candidatNom;
    }

    public String getCandidatPrenoms() {
        return this.candidatPrenoms;
    }

    public void setCandidatPrenoms(String candidatPrenoms) {
        this.candidatPrenoms = candidatPrenoms;
    }

    public Byte[] getCandidatPhoto() {
        return this.candidatPhoto;
    }

    public void setCandidatPhoto(Byte[] candidatPhoto) {
        this.candidatPhoto = candidatPhoto;
    }

    public String getCandidatEmail() {
        return this.candidatEmail;
    }

    public void setCandidatEmail(String candidatEmail) {
        this.candidatEmail = candidatEmail;
    }

    public String getCandidatTelephone() {
        return this.candidatTelephone;
    }

    public void setCandidatTelephone(String candidatTelephone) {
        this.candidatTelephone = candidatTelephone;
    }

    public Evenement getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

}
