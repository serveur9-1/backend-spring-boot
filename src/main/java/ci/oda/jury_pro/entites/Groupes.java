package ci.oda.jury_pro.entites;

import javax.persistence.*;

@Entity
@Table(name = "groupes")
public class Groupes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupeId;
    private String groupeCode;
    private String groupeNom;
    private Byte[] groupePhoto;
    @ManyToOne
    private Evenement evenement;

    public Long getGroupeId() {
        return this.groupeId;
    }

    public void setGroupeId(Long groupeId) {
        this.groupeId = groupeId;
    }

    public String getGroupeCode() {
        return this.groupeCode;
    }

    public void setGroupeCode(String groupeCode) {
        this.groupeCode = groupeCode;
    }

    public String getGroupeNom() {
        return this.groupeNom;
    }

    public void setGroupeNom(String groupeNom) {
        this.groupeNom = groupeNom;
    }

    public Byte[] getGroupePhoto() {
        return this.groupePhoto;
    }

    public void setGroupePhoto(Byte[] groupePhoto) {
        this.groupePhoto = groupePhoto;
    }

    public Evenement getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

}
