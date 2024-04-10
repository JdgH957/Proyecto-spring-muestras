package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.MedicalHistory;

public interface IMedicalHistoryService {
    
    List<MedicalHistory> getMedicalHistory();
    
    MedicalHistory nuevoMedicalHistory(MedicalHistory medicalHistory);
    
    MedicalHistory buscarMedicalHistory(Long id);
    
    int borrarMedicalHistory(Long id);
}
