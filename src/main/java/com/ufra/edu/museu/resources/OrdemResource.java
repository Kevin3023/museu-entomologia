package com.ufra.edu.museu.resources;

import com.sun.jdi.Value;
import com.ufra.edu.museu.entities.Ordem;
import com.ufra.edu.museu.services.OrdemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/ordem")
public class OrdemResource {

    @Autowired
    private OrdemService service;

    @ApiOperation(value = "Recupera todos os registros de ordens")
    @GetMapping
    public ResponseEntity<List<Ordem>> findAll(){

        List<Ordem> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de ordem por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Ordem> findById(@PathVariable Long id){
        Ordem obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria uma nova ordem e cadastra ela no banco de dados")
    @PostMapping
    public ResponseEntity<Ordem> insert(@RequestBody Ordem obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta uma ordem através do id dela")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Ordem> update(@PathVariable Long id, @RequestBody Ordem obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
