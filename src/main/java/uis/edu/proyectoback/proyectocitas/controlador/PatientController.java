/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.proyectoback.proyectocitas.controlador;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Patient;
import uis.edu.proyectoback.proyectocitas.servicio.PatientService;
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
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;
    
    @GetMapping("/list/")
    public List<Patient> cargarPatient(){  
        return patientService.getPatient();
    }
    
    // Buscar por Id
    @GetMapping("/list/{id}")
    public Patient buscarPorId(@PathVariable Long id) {
        return patientService.buscarPatient(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Patient> agregar(@RequestBody Patient patient) {
        Patient obj = patientService.nuevoPatient(patient);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Patient> editar(@RequestBody Patient patient) {
        Patient obj = patientService.buscarPatient(patient.getId());
        if (obj != null) {
            obj.setId(patient.getId());
            obj.setFullName(patient.getFullName());
            obj.setUser(patient.getUser());
            patientService.nuevoPatient(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> eliminar(@PathVariable Long id) {
        Patient obj = patientService.buscarPatient(id);
        if (obj != null) {
            patientService.borrarPatient(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }    
}
