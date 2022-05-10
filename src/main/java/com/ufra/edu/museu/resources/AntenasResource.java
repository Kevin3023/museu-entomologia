package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Antenas;
import com.ufra.edu.museu.services.AntenasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/antenas")
public class AntenasResource {

    @Autowired
    private AntenasService service;

    @GetMapping
    public ResponseEntity<List<Antenas>> findAll(){

        List<Antenas> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Antenas> findById(@PathVariable Long id){
        Antenas obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Antenas> insert(@RequestBody Antenas obj){
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
    public ResponseEntity<Antenas> update(@PathVariable Long id, @RequestBody Antenas obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
