package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Especies;
import com.ufra.edu.museu.services.EspeciesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/especies")
public class EspeciesResource {

    @Autowired
    private EspeciesService service;

    @ApiOperation(value = "Recupera todos os registros de espécies")
    @GetMapping
    public ResponseEntity<List<Especies>> findAll(){

        List<Especies> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera uma espécie por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Especies> findById(@PathVariable Long id){
        Especies obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria uma nova espécie e cadastra ela no banco de dados")
    @PostMapping
    public ResponseEntity<Especies> insert(@RequestBody Especies obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta uma espécie através do id dela")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Especies> update(@PathVariable Long id, @RequestBody Especies obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
