package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Doctor;

public interface IDoctorService {
    
    List<Doctor> getDoctor();
    
    Doctor nuevoDoctor(Doctor doctor);
    
    Doctor buscarDoctor(Long id);
    
    int borrarDoctor(Long id);
}
