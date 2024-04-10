
package uis.edu.proyectoback.proyectocitas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorREST {
    
    @GetMapping("/")
    public String comienzo(){
    
        return "Hola Mundo";
    }
    
}
