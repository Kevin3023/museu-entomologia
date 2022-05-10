package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Abdomen;
import com.ufra.edu.museu.services.AbdomenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/abdomens")
public class AbdomenResource {

    private AbdomenService service;

    @GetMapping
    public ResponseEntity<List<Abdomen>> findAll(){

        List<Abdomen> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Abdomen> findById(@PathVariable Long id){
        Abdomen obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Abdomen> insert(@RequestBody Abdomen obj){
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
    public ResponseEntity<Abdomen> update(@PathVariable Long id, @RequestBody Abdomen obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
