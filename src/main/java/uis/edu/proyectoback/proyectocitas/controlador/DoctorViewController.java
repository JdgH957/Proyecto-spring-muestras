package uis.edu.proyectoback.proyectocitas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorViewController {
    
     @GetMapping("/doctor/home")
    public String showDoctorHomeForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "index_doctor";
    } 
    
    @GetMapping("/doctor/pending/detail")
    public String showDetailAppointmentPendingForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "cita_pendiente";
    } 
    
    @GetMapping("/doctor/finished/detail")
    public String showDetailAppointmentFinishedForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "cita_finalizada";
    }     
    
    @GetMapping("/doctor/future/detail")
    public String showDetailAppointmentFutureForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "cita_proxima";
    }     
    
    
    @GetMapping("/doctor/profile")
    public String showProfileForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "doctor_profile";
    }   
    
    @GetMapping("/doctor/shedule")
    public String showSheduleForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "agendar_encargado";
    }    
    
    @GetMapping("/doctor/new_appointment")
    public String showNewAppointmentForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "new_appointment";
    }     
}
