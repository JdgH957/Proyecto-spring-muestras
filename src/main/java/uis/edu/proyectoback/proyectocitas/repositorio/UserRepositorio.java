package uis.edu.proyectoback.proyectocitas.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.proyectoback.proyectocitas.modelo.User;

public interface UserRepositorio extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username); 
}
