package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.proyectoback.proyectocitas.modelo.Appointment;
import uis.edu.proyectoback.proyectocitas.repositorio.AppointmentRepositorio;

@Service
@Transactional
public class AppointmentService implements IAppointmentService {

    @Autowired
    AppointmentRepositorio appointmentRepositorio;
    
    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepositorio.findAll();
    }

    @Override
    public Appointment nuevoAppointment(Appointment appointment) {
        return appointmentRepositorio.save(appointment);
    }

    @Override
    public Appointment buscarAppointment(Long id) {
        return appointmentRepositorio.findById(id).orElse(null);
    }

    @Override
    public int borrarAppointment(Long id) {
        appointmentRepositorio.deleteById(id);
        return 1;
    }    
}
