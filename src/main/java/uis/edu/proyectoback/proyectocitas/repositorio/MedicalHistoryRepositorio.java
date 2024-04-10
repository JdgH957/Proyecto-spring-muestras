package uis.edu.proyectoback.proyectocitas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.proyectoback.proyectocitas.modelo.MedicalHistory;

public interface MedicalHistoryRepositorio extends JpaRepository<MedicalHistory, Long>{
    
}
