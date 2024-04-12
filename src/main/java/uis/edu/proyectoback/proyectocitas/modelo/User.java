package uis.edu.proyectoback.proyectocitas.modelo;

import java.util.Collection;
import java.util.List;
import java.util.Arrays;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = User.TABLE_NAME)
public class User implements UserDetails {
    
    public static final String  TABLE_NAME = "user";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username; 
    
    @Column(name = "password")
    private String password; 
    
    @Column(name = "email")
    private String email; 
    
    @Column(name = "role")
    @Enumerated(EnumType.STRING) 
    Role role;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
