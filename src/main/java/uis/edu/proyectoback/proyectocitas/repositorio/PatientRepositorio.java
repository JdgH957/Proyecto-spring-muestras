package uis.edu.proyectoback.proyectocitas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.proyectoback.proyectocitas.modelo.Patient;

public interface PatientRepositorio extends JpaRepository<Patient, Long>{
    
}