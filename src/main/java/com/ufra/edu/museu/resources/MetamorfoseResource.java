package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Metamorfose;
import com.ufra.edu.museu.services.MetamorfoseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/metamorfoses")
public class MetamorfoseResource {

    @Autowired
    private MetamorfoseService service;

    @ApiOperation(value = "Recupera todos os registros de metamorfoses")
    @GetMapping
    public ResponseEntity<List<Metamorfose>> findAll(){

        List<Metamorfose> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de uma metamorfose por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Metamorfose> findById(@PathVariable Long id){
        Metamorfose obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria uma nova metamrfose e cadastra ela no banco de dados")
    @PostMapping
    public ResponseEntity<Metamorfose> insert(@RequestBody Metamorfose obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta uma metamorfose através do id dela")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Metamorfose> update(@PathVariable Long id, @RequestBody Metamorfose obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
