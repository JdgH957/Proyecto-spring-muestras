package uis.edu.proyectoback.proyectocitas.controlador;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Appointment;
import uis.edu.proyectoback.proyectocitas.servicio.AppointmentService;
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
@RequestMapping("/api/citas")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    
    @GetMapping("/list/")
    public List<Appointment> getAppointments() {  
        return appointmentService.getAppointments();
    }
    
    // Buscar por Id
    @GetMapping("/list/{id}")
    public Appointment buscarPorId(@PathVariable Long id) {
        return appointmentService.buscarAppointment(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Appointment> agregar(@RequestBody Appointment appointment) {
        Appointment obj = appointmentService.nuevoAppointment(appointment);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Appointment> editar(@RequestBody Appointment appointment) {
        Appointment obj = appointmentService.buscarAppointment(appointment.getId());
        if (obj != null) {
            obj.setPatient(appointment.getPatient());
            obj.setDoctor(appointment.getDoctor());
            obj.setDate(appointment.getDate());
            obj.setStatus(appointment.getStatus());
            appointmentService.nuevoAppointment(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Appointment> eliminar(@PathVariable Long id) {
        int result = appointmentService.borrarAppointment(id);
        if (result == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    
}
