package uis.edu.proyectoback.proyectocitas.controlador;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.User;
import uis.edu.proyectoback.proyectocitas.servicio.UserService;
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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("/list/")
    public List<User> cargarUser(){  
        return userService.getUser();
    }    
    
        // Buscar por Id
    @GetMapping("/list/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return userService.buscarUser(id);
    }

    @PostMapping("/")
    public ResponseEntity<User> agregar(@RequestBody User usuario) {
        User obj = userService.nuevoUser(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<User> editar(@RequestBody User usuario) {
        User obj = userService.buscarUser(usuario.getId());
        if (obj != null) {
            obj.setUsername(usuario.getUsername());
            obj.setPassword(usuario.getPassword());
            obj.setEmail(usuario.getEmail());
            obj.setRole(usuario.getRole());
            userService.nuevoUser(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> eliminar(@PathVariable Long id) {
        User obj = userService.buscarUser(id);
        if (obj != null) {
            userService.borrarUser(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
