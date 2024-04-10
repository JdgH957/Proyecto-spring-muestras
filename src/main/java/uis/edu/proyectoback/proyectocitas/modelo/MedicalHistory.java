package uis.edu.proyectoback.proyectocitas.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medicalhistory")
public class MedicalHistory {

    @Id
    @Column(name = "id")
    private Long id;    
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    @Column(name = "medical_history", columnDefinition = "TEXT")
    private String medicalHistory;

    @Column(name = "current_residence_city", length = 255)
    private String currentResidenceCity;

    @Column(name = "previous_residence_cities", columnDefinition = "TEXT")
    private String previousResidenceCities;

    @Column(name = "current_symptoms")
    private int currentSymptoms;

    @Column(name = "contact_with_sick_people")
    private int contactWithSickPeople;

    @Column(name = "release_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;
    
    public MedicalHistory() {
    }

    // Constructor con todos los campos
    public MedicalHistory(Patient patient, String medicalHistory, String currentResidenceCity, String previousResidenceCities, int currentSymptoms, int contactWithSickPeople, Date releaseDate) {
        this.patient = patient;
        this.medicalHistory = medicalHistory;
        this.currentResidenceCity = currentResidenceCity;
        this.previousResidenceCities = previousResidenceCities;
        this.currentSymptoms = currentSymptoms;
        this.contactWithSickPeople = contactWithSickPeople;
        this.releaseDate = releaseDate;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentResidenceCity() {
        return currentResidenceCity;
    }

    public void setCurrentResidenceCity(String currentResidenceCity) {
        this.currentResidenceCity = currentResidenceCity;
    }

    public String getPreviousResidenceCities() {
        return previousResidenceCities;
    }

    public void setPreviousResidenceCities(String previousResidenceCities) {
        this.previousResidenceCities = previousResidenceCities;
    }

    public int getCurrentSymptoms() {
        return currentSymptoms;
    }

    public void setCurrentSymptoms(int currentSymptoms) {
        this.currentSymptoms = currentSymptoms;
    }

    public int getContactWithSickPeople() {
        return contactWithSickPeople;
    }

    public void setContactWithSickPeople(int contactWithSickPeople) {
        this.contactWithSickPeople = contactWithSickPeople;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
