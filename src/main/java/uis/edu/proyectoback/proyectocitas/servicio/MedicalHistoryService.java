package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.proyectoback.proyectocitas.modelo.MedicalHistory;
import uis.edu.proyectoback.proyectocitas.repositorio.MedicalHistoryRepositorio;

@Service
@Transactional
public class MedicalHistoryService implements IMedicalHistoryService {

    @Autowired
    MedicalHistoryRepositorio medicalHistoryRepositorio;
    
    @Override
    public List<MedicalHistory> getMedicalHistory() {
        return medicalHistoryRepositorio.findAll();
    }

    @Override
    public MedicalHistory nuevoMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepositorio.save(medicalHistory);
    }

    @Override
    public MedicalHistory buscarMedicalHistory(Long id) {
        return medicalHistoryRepositorio.findById(id).orElse(null);
    }

    @Override
    public int borrarMedicalHistory(Long id) {
        medicalHistoryRepositorio.deleteById(id);
        return 1;
    }    
}
