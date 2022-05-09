package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Aparelho_bucal;
import com.ufra.edu.museu.services.Aparelho_bucalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/bocas")
public class Aparelho_bucalResource {

    @Autowired
    private Aparelho_bucalService service;

    @GetMapping
    public ResponseEntity<List<Aparelho_bucal>> findAll(){

        List<Aparelho_bucal> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aparelho_bucal> findById(@PathVariable Long id){
        Aparelho_bucal obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Aparelho_bucal> insert(@RequestBody Aparelho_bucal obj){
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
    public ResponseEntity<Aparelho_bucal> update(@PathVariable Long id, @RequestBody Aparelho_bucal obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
