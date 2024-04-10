package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Appointment;

public interface IAppointmentService {
    List<Appointment> getAppointments();
    
    Appointment nuevoAppointment(Appointment appointment);
    
    Appointment buscarAppointment(Long id);
    
    int borrarAppointment(Long id);
}