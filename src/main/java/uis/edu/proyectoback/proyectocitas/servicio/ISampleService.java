package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Sample;

public interface ISampleService {
    List<Sample> getSamples();
    
    Sample createSample(Sample sample);
    
    Sample findSample(Long id);
    
    int deleteSample(Long id);
}
