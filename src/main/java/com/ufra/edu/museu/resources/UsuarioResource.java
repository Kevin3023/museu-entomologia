package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario(1L, "Kevin Gomes", "kevin@gmail.com", "12345");

        return ResponseEntity.ok().body(u);
    }
}
