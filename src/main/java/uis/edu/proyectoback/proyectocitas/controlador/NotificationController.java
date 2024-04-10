/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.proyectoback.proyectocitas.controlador;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Notification;
import uis.edu.proyectoback.proyectocitas.servicio.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    NotificationService notificationService;
    
    @GetMapping("/list/")
    public List<Notification> cargarNotifications(){  
        return notificationService.getNotifications();
    }
    
    // Buscar por Id
    @GetMapping("/list/{id}")
    public Notification buscarPorId(@PathVariable Long id) {
        return notificationService.findNotification(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Notification> agregar(@RequestBody Notification notification) {
        Notification obj = notificationService.createNotification(notification);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Notification> editar(@RequestBody Notification notification) {
        Notification obj = notificationService.findNotification(notification.getId());
        if (obj != null) {
            obj.setUser(notification.getUser());
            obj.setSenderId(notification.getSenderId());
            obj.setMessage(notification.getMessage());
            obj.setType(notification.getType());
            obj.setDate(notification.getDate());
            notificationService.createNotification(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notification> eliminar(@PathVariable Long id) {
        Notification obj = notificationService.findNotification(id);
        if (obj != null) {
            notificationService.deleteNotification(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }    
}
