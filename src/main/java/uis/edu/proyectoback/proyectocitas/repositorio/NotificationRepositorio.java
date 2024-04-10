package uis.edu.proyectoback.proyectocitas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.proyectoback.proyectocitas.modelo.Notification;

public interface NotificationRepositorio extends JpaRepository<Notification, Long>{
    
}
