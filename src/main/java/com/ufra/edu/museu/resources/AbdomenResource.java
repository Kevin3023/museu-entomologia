package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Abdomen;
import com.ufra.edu.museu.services.AbdomenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/abdomens")
public class AbdomenResource {

    @Autowired
    private AbdomenService service;

    @ApiOperation(value = "Recupera todos os registros de abdomens")
    @GetMapping
    public ResponseEntity<List<Abdomen>> findAll(){

        List<Abdomen> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de abdomen por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Abdomen> findById(@PathVariable Long id){
        Abdomen obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria um novo abdomen e cadastra ele no banco de dados")
    @PostMapping
    public ResponseEntity<Abdomen> insert(@RequestBody Abdomen obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta um abdomen através do id dele")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Abdomen> update(@PathVariable Long id, @RequestBody Abdomen obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
