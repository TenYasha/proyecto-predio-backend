package com.proyectojwt.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Table(name = "tb_usuario")
@Entity
public class Usuario implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	private boolean enabled=true;

	private String nombre;
	private String apellido;
	
	@NotBlank(message = "El username obligatorio")
	@Size(min = 3,max=50,message = "El username min:3 max:50 caracteres")
	private String username;
	
	@NotBlank(message = "El password es obligatorio")
	@Size(min = 3, message = "El password debe tener 3 caracteres")
	private String password;

		@ManyToMany( fetch = FetchType.EAGER)
		@JoinTable(name = "tb_usuario_rol", // nombre tb intemedia
				joinColumns = @JoinColumn(name = "id_usuario"), //nombre fk de usuario
				inverseJoinColumns = @JoinColumn(name = "id_rol") // nombre fk de rol
		)
		private Set<Rol> roles= new HashSet<>();


	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}


	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 Set<Authority> autoridades = new HashSet<>();
	        this.roles.forEach(usuarioRol -> {
	            autoridades.add(new Authority(usuarioRol.getNombre()));
	        });
	        return autoridades;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
