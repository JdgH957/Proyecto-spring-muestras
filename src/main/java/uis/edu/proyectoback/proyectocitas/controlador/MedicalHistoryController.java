package uis.edu.proyectoback.proyectocitas.controlador;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.MedicalHistory;
import uis.edu.proyectoback.proyectocitas.servicio.MedicalHistoryService;
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
@RequestMapping("/api/medical_history")
public class MedicalHistoryController {
    @Autowired
    MedicalHistoryService medicalHistoryService;
    
    @GetMapping("/list/")
    public List<MedicalHistory> getMedicalHistory(){  
        return medicalHistoryService.getMedicalHistory();
    }
    
    // Buscar por Id
    @GetMapping("/list/{id}")
    public MedicalHistory buscarPorId(@PathVariable Long id) {
        return medicalHistoryService.buscarMedicalHistory(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<MedicalHistory> agregar(@RequestBody MedicalHistory medicalHistory) {
        MedicalHistory obj = medicalHistoryService.nuevoMedicalHistory(medicalHistory);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<MedicalHistory> editar(@RequestBody MedicalHistory medicalHistory) {
        MedicalHistory obj = medicalHistoryService.buscarMedicalHistory(medicalHistory.getId());
        if (obj != null) {
            obj.setId(medicalHistory.getId());
            obj.setPatient(medicalHistory.getPatient());
            obj.setMedicalHistory(medicalHistory.getMedicalHistory());
            obj.setCurrentResidenceCity(medicalHistory.getCurrentResidenceCity());
            obj.setPreviousResidenceCities(medicalHistory.getPreviousResidenceCities());
            obj.setCurrentSymptoms(medicalHistory.getCurrentSymptoms());
            obj.setContactWithSickPeople(medicalHistory.getContactWithSickPeople());
            obj.setReleaseDate(medicalHistory.getReleaseDate());
            medicalHistoryService.nuevoMedicalHistory(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicalHistory> eliminar(@PathVariable Long id) {
        int result = medicalHistoryService.borrarMedicalHistory(id);
        if (result == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    
}
