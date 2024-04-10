package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.proyectoback.proyectocitas.modelo.Notification;
import uis.edu.proyectoback.proyectocitas.repositorio.NotificationRepositorio;

@Service
@Transactional
public class NotificationService implements INotificationService {

    @Autowired
    NotificationRepositorio notificationRepositorio;
    
    @Override
    public List<Notification> getNotifications() {
        return notificationRepositorio.findAll();
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepositorio.save(notification);
    }

    @Override
    public Notification findNotification(Long id) {
        return notificationRepositorio.findById(id).orElse(null);
    }

    @Override
    public int deleteNotification(Long id) {
        notificationRepositorio.deleteById(id);
        return 1;
    }    
}
