package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Genero;
import com.ufra.edu.museu.services.GeneroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/generos")
public class GeneroResource {

    @Autowired
    private GeneroService service;

    @ApiOperation(value = "Recupera todos os registros de generos")
    @GetMapping
    public ResponseEntity<List<Genero>> findAll(){

        List<Genero> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de genero por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Genero> findById(@PathVariable Long id){
        Genero obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria um novo genero e cadastra ele no banco de dados")
    @PostMapping
    public ResponseEntity<Genero> insert(@RequestBody Genero obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta um genero através do id dele")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Genero> update(@PathVariable Long id, @RequestBody Genero obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
