/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.proyectoback.proyectocitas.modelo;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "credentials")
    private String credentials;

    @OneToOne
    @JoinColumn(name = "id")
    private User user; 
    
    public Doctor() {
    }

    // Constructor con todos los campos
    public Doctor(String fullName, String credentials, User user) {
        this.user = user;
        this.fullName = fullName;
        this.credentials = credentials;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
