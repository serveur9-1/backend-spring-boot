package ci.oda.jury_pro.entites;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "evenements")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evenementId;
    private String evenementNom;
    private String evenementType;
    private Date evenementDateDebut;
    private Date evenementDateFin;

    public Long getEvenementId() {
        return this.evenementId;
    }

    public void setEvenementId(Long evenementId) {
        this.evenementId = evenementId;
    }

    public String getEvenementNom() {
        return this.evenementNom;
    }

    public void setEvenementNom(String evenementNom) {
        this.evenementNom = evenementNom;
    }

    public String getEvenementType() {
        return this.evenementType;
    }

    public void setEvenementType(String evenementType) {
        this.evenementType = evenementType;
    }

    public Date getEvenementDateDebut() {
        return this.evenementDateDebut;
    }

    public void setEvenementDateDebut(Date evenementDateDebut) {
        this.evenementDateDebut = evenementDateDebut;
    }

    public Date getEvenementDateFin() {
        return this.evenementDateFin;
    }

    public void setEvenementDateFin(Date evenementDateFin) {
        this.evenementDateFin = evenementDateFin;
    }

}
