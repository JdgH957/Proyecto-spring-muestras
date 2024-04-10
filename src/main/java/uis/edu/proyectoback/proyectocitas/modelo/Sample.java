package uis.edu.proyectoback.proyectocitas.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sample")
public class Sample {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @Column(name = "type", length = 255)
    private String type;

    @Column(name = "collection_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDate;

    @Column(name = "analysis_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date analysisDate;

    @Column(name = "status", length = 255)
    private String status;

    // Constructor vacío
    public Sample() {
    }

    // Constructor con todos los campos
    public Sample(Appointment appointment, String type, Date collectionDate, Date analysisDate, String status) {
        this.appointment = appointment;
        this.type = type;
        this.collectionDate = collectionDate;
        this.analysisDate = analysisDate;
        this.status = status;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Date getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Date analysisDate) {
        this.analysisDate = analysisDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
