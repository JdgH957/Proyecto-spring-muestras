package uis.edu.proyectoback.proyectocitas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.proyectoback.proyectocitas.modelo.Doctor;

public interface DoctorRepositorio extends JpaRepository<Doctor, Long>{
    
}
