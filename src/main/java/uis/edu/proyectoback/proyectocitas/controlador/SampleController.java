package uis.edu.proyectoback.proyectocitas.controlador;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Sample;
import uis.edu.proyectoback.proyectocitas.servicio.SampleService;
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
@RequestMapping("/api/samples")
public class SampleController {
    @Autowired
    SampleService sampleService;
    
    @GetMapping("/list/")
    public List<Sample> cargarSamples(){  
        return sampleService.getSamples();
    }
    
    // Buscar por Id
    @GetMapping("/list/{id}")
    public Sample buscarPorId(@PathVariable Long id) {
        return sampleService.findSample(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Sample> agregar(@RequestBody Sample sample) {
        Sample obj = sampleService.createSample(sample);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Sample> editar(@RequestBody Sample sample) {
        Sample obj = sampleService.findSample(sample.getId());
        if (obj != null) {
            obj.setAppointment(sample.getAppointment());
            obj.setType(sample.getType());
            obj.setCollectionDate(sample.getCollectionDate());
            obj.setAnalysisDate(sample.getAnalysisDate());
            obj.setStatus(sample.getStatus());
            sampleService.createSample(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sample> eliminar(@PathVariable Long id) {
        Sample obj = sampleService.findSample(id);
        if (obj != null) {
            sampleService.deleteSample(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }    
}
