package uis.edu.proyectoback.proyectocitas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.proyectoback.proyectocitas.modelo.Appointment;

public interface AppointmentRepositorio extends JpaRepository<Appointment, Long>{
    
}
