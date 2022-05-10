package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Antenas;
import com.ufra.edu.museu.services.AntenasService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Recupera todos os registros de Antenas")
    @GetMapping
    public ResponseEntity<List<Antenas>> findAll(){

        List<Antenas> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de uma antena por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Antenas> findById(@PathVariable Long id){
        Antenas obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria uma nova antena e cadastra ela no banco de dados")
    @PostMapping
    public ResponseEntity<Antenas> insert(@RequestBody Antenas obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta uma antena através do id dele")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Antenas> update(@PathVariable Long id, @RequestBody Antenas obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
