/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.Patient;


public interface IPatientService {
    List<Patient> getPatient();
    
    Patient nuevoPatient(Patient patient);
    
    Patient buscarPatient(Long id);
    
    int borrarPatient(Long id);
}