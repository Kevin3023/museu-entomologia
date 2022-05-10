package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Filo;
import com.ufra.edu.museu.services.FiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/filos")
public class FiloResource {

    @Autowired
    private FiloService service;

    @GetMapping
    public ResponseEntity<List<Filo>> findAll(){

        List<Filo> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filo> findById(@PathVariable Long id){
        Filo obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Filo> insert(@RequestBody Filo obj){
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
    public ResponseEntity<Filo> update(@PathVariable Long id, @RequestBody Filo obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
