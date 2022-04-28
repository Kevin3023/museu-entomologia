package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Genero;
import com.ufra.edu.museu.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/generos")
public class GeneroResource {

    @Autowired
    private GeneroService service;

    @GetMapping
    public ResponseEntity<List<Genero>> findAll(){

        List<Genero> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genero> findById(@PathVariable Long id){
        Genero obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Genero> insert(@RequestBody Genero obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Genero> update(@PathVariable Long id, @RequestBody Genero obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
