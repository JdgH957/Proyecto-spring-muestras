package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Notification;

public interface INotificationService {
    List<Notification> getNotifications();
    
    Notification createNotification(Notification notification);
    
    Notification findNotification(Long id);
    
    int deleteNotification(Long id);
}

