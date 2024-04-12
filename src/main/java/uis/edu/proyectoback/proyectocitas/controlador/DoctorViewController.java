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
    
    
}
