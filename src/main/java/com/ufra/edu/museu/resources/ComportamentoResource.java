package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Comportamento;
import com.ufra.edu.museu.services.ComportamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/comportamentos")
public class ComportamentoResource {

    @Autowired
    private ComportamentoService service;

    @GetMapping
    public ResponseEntity<List<Comportamento>> findAll(){

        List<Comportamento> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comportamento> findById(@PathVariable Long id){
        Comportamento obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Comportamento> insert(@RequestBody Comportamento obj){
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
    public ResponseEntity<Comportamento> update(@PathVariable Long id, @RequestBody Comportamento obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
