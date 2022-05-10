package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Pernas;
import com.ufra.edu.museu.services.PernasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/pernas")
public class PernasResource {

    private PernasService service;

    @GetMapping
    public ResponseEntity<List<Pernas>> findAll(){

        List<Pernas> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pernas> findById(@PathVariable Long id){
        Pernas obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Pernas> insert(@RequestBody Pernas obj){
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
    public ResponseEntity<Pernas> update(@PathVariable Long id, @RequestBody Pernas obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
