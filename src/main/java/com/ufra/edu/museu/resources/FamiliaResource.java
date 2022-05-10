package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Familia;
import com.ufra.edu.museu.services.FamiliaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/familias")
public class FamiliaResource {

    @Autowired
    private FamiliaService service;

    @ApiOperation(value = "Recupera todos os registros de familias")
    @GetMapping
    public ResponseEntity<List<Familia>> findAll(){

        List<Familia> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de familia por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Familia> findById(@PathVariable Long id){
        Familia obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria uma nova familia e cadastra ele no banco de dados")
    @PostMapping
    public ResponseEntity<Familia> insert(@RequestBody Familia obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta uma familia através do id dela")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Familia> update(@PathVariable Long id, @RequestBody Familia obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
