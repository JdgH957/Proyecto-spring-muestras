/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.proyectoback.proyectocitas.servicio;

import java.util.List;
import uis.edu.proyectoback.proyectocitas.modelo.User;


public interface IUserService {
    List<User> getUser();
    
    User nuevoUser(User user);
    
    User buscarUser(Long id);
    
    int borrarUser(Long id);
}
