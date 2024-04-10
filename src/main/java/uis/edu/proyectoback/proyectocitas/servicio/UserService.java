/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.proyectoback.proyectocitas.modelo.User;
import uis.edu.proyectoback.proyectocitas.repositorio.UserRepositorio;


@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    UserRepositorio userRepositorio;
    
    @Override
    public List<User> getUser() {
        return userRepositorio.findAll();
    }

    @Override
    public User nuevoUser(User user) {
        return userRepositorio.save(user);
    }

    @Override
    public User buscarUser(Long id) {
        User user = null;
        user = userRepositorio.findById(id).orElse(null);
        if (user == null){
            return null;
        }
        return user;
    }

    @Override
    public int borrarUser(Long id) {
        userRepositorio.deleteById(id);
        return 1;
    }    
}
