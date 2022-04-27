package com.ufra.edu.museu.repositories;

import com.ufra.edu.museu.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
