package ci.oda.jury_pro.entites;

import javax.persistence.*;

@Entity
@Table(name = "criteres")
public class Criteres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long critereId;
    private String critereLibelle;
    private String critereBareme;
    @ManyToOne
    private Evenement evenement;

    public Long getCritereId() {
        return this.critereId;
    }

    public void setCritereId(Long critereId) {
        this.critereId = critereId;
    }

    public String getCritereLibelle() {
        return this.critereLibelle;
    }

    public void setCritereLibelle(String critereLibelle) {
        this.critereLibelle = critereLibelle;
    }

    public String getCritereBareme() {
        return this.critereBareme;
    }

    public void setCritereBareme(String critereBareme) {
        this.critereBareme = critereBareme;
    }

    public Evenement getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

}
