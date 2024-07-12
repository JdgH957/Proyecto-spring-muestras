package uis.edu.proyectoback.proyectocitas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacientViewController {
    
    @GetMapping("/pacient/home")
    public String showPacientHomeForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "index_pacient";
    }
    
    @GetMapping("/pacient/notificaciones")
    public String showNotificacionesPacientHomeForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "notificaciones_paciente";
    }
    
    @GetMapping("/pacient/home/detail")
    public String showDetailAppointmentHomeForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "appointment_detail_pacient";
    }   
    
    @GetMapping("/pacient/profile")
    public String showProfileForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "pacient_profile";
    }
    
    @GetMapping("/pacient/shedule")
    public String showSheduleForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "agendar_paciente";
    }     
}
