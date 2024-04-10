package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.proyectoback.proyectocitas.modelo.Patient;
import uis.edu.proyectoback.proyectocitas.repositorio.PatientRepositorio;

@Service
@Transactional
public class PatientService implements IPatientService{
    @Autowired
    PatientRepositorio patientRepositorio;
    
    @Override
    public List<Patient> getPatient() {
        return patientRepositorio.findAll();
    }

    @Override
    public Patient nuevoPatient(Patient patient) {
        return patientRepositorio.save(patient);
    }

    @Override
    public Patient buscarPatient(Long id) {
        return patientRepositorio.findById(id).orElse(null);
    }

    @Override
    public int borrarPatient(Long id) {
        patientRepositorio.deleteById(id);
        return 1;
    }      
}
