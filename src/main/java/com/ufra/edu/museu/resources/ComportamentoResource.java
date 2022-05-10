package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Comportamento;
import com.ufra.edu.museu.services.ComportamentoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/comportamentos")
public class ComportamentoResource {

    @Autowired
    private ComportamentoService service;

    @ApiOperation(value = "Recupera todos os registros de comportamento")
    @GetMapping
    public ResponseEntity<List<Comportamento>> findAll(){

        List<Comportamento> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de comportamento por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Comportamento> findById(@PathVariable Long id){
        Comportamento obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria um novo registro comportamento e cadastra ele no banco de dados")
    @PostMapping
    public ResponseEntity<Comportamento> insert(@RequestBody Comportamento obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta um comportamento através do id dele")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Comportamento> update(@PathVariable Long id, @RequestBody Comportamento obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
