package uis.edu.proyectoback.proyectocitas.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String showLoginForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegisterForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "register";
    }
    
    @GetMapping("/register/patient")
    public String showRegisterPatientForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "pacient_register";
    }
    
    @GetMapping("/register/doctor")
    public String showRegisterDoctorForm() {
        // Retorna el nombre de la plantilla HTML (sin la extensión .html)
        // Asegúrate de que el archivo se encuentra bajo src/main/resources/templates
        return "doctor_register";
    }
    
    // Puedes añadir más métodos aquí para otras vistas
}
