package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.proyectoback.proyectocitas.modelo.Sample;
import uis.edu.proyectoback.proyectocitas.repositorio.SampleRepositorio;

@Service
@Transactional
public class SampleService implements ISampleService {

    @Autowired
    SampleRepositorio sampleRepositorio;
    
    @Override
    public List<Sample> getSamples() {
        return sampleRepositorio.findAll();
    }

    @Override
    public Sample createSample(Sample sample) {
        return sampleRepositorio.save(sample);
    }

    @Override
    public Sample findSample(Long id) {
        return sampleRepositorio.findById(id).orElse(null);
    }

    @Override
    public int deleteSample(Long id) {
        sampleRepositorio.deleteById(id);
        return 1;
    }    
}
