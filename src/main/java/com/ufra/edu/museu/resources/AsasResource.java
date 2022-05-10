package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Asas;
import com.ufra.edu.museu.services.AsasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/asas")
public class AsasResource {

    private AsasService service;

    @GetMapping
    public ResponseEntity<List<Asas>> findAll(){

        List<Asas> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Asas> findById(@PathVariable Long id){
        Asas obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Asas> insert(@RequestBody Asas obj){
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
    public ResponseEntity<Asas> update(@PathVariable Long id, @RequestBody Asas obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
