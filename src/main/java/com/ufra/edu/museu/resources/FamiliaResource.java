package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Familia;
import com.ufra.edu.museu.services.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/familias")
public class FamiliaResource {

    @Autowired
    private FamiliaService service;

    @GetMapping
    public ResponseEntity<List<Familia>> findAll(){

        List<Familia> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Familia> findById(@PathVariable Long id){
        Familia obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Familia> insert(@RequestBody Familia obj){
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
    public ResponseEntity<Familia> update(@PathVariable Long id, @RequestBody Familia obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
