package com.proyectojwt.repository;

import com.proyectojwt.entity.Rol;
import com.proyectojwt.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Integer> {

    Rol findByNombre(Rol rol);


}
