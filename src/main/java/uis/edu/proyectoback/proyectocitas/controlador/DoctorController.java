package uis.edu.proyectoback.proyectocitas.controlador;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Doctor;
import uis.edu.proyectoback.proyectocitas.servicio.DoctorService;
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
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    
    @GetMapping("/list/")
    public List<Doctor> cargarDoctor(){  
        return doctorService.getDoctor();
    }  
    
        // Buscar por Id
    @GetMapping("/list/{id}")
    public Doctor buscarPorId(@PathVariable Long id) {
        return doctorService.buscarDoctor(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Doctor> agregar(@RequestBody Doctor doctor) {
        Doctor obj = doctorService.nuevoDoctor(doctor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Doctor> editar(@RequestBody Doctor doctor) {
        Doctor obj = doctorService.buscarDoctor(doctor.getId());
        if (obj != null) {
            obj.setId(doctor.getId());
            obj.setFullName(doctor.getFullName());
            obj.setCredentials(doctor.getCredentials());
            obj.setUser(doctor.getUser());
            doctorService.nuevoDoctor(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> eliminar(@PathVariable Long id) {
        Doctor obj = doctorService.buscarDoctor(id);
        if (obj != null) {
            doctorService.borrarDoctor(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}