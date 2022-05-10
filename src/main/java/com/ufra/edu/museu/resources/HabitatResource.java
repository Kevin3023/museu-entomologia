package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Habitat;
import com.ufra.edu.museu.services.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/habitats")
public class HabitatResource {

    @Autowired
    private HabitatService service;

    @GetMapping
    public ResponseEntity<List<Habitat>> findAll(){

        List<Habitat> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Habitat> findById(@PathVariable Long id){
        Habitat obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Habitat> insert(@RequestBody Habitat obj){
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
    public ResponseEntity<Habitat> update(@PathVariable Long id, @RequestBody Habitat obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
