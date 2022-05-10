package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Habitat;
import com.ufra.edu.museu.services.HabitatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/habitats")
public class HabitatResource {

    @Autowired
    private HabitatService service;

    @ApiOperation(value = "Recupera todos os registros de habitats")
    @GetMapping
    public ResponseEntity<List<Habitat>> findAll(){

        List<Habitat> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de habitats por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Habitat> findById(@PathVariable Long id){
        Habitat obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria um novo habitat e cadastra ele no banco de dados")
    @PostMapping
    public ResponseEntity<Habitat> insert(@RequestBody Habitat obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta um habitat através do id dele")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Habitat> update(@PathVariable Long id, @RequestBody Habitat obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
