package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.proyectoback.proyectocitas.modelo.Doctor;
import uis.edu.proyectoback.proyectocitas.repositorio.DoctorRepositorio;

@Service
@Transactional
public class DoctorService implements IDoctorService {

    @Autowired
    DoctorRepositorio doctorRepositorio;
    
    @Override
    public List<Doctor> getDoctor() {
        return doctorRepositorio.findAll();
    }

    @Override
    public Doctor nuevoDoctor(Doctor doctor) {
        return doctorRepositorio.save(doctor);
    }

    @Override
    public Doctor buscarDoctor(Long id) {
        return doctorRepositorio.findById(id).orElse(null);
    }

    @Override
    public int borrarDoctor(Long id) {
        doctorRepositorio.deleteById(id);
        return 1;
    }    
}