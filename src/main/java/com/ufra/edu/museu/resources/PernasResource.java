package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Pernas;
import com.ufra.edu.museu.services.PernasService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/pernas")
public class PernasResource {

    @Autowired
    private PernasService service;

    @ApiOperation(value = "Recupera todos os registros de pernas")
    @GetMapping
    public ResponseEntity<List<Pernas>> findAll(){

        List<Pernas> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de perna por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pernas> findById(@PathVariable Long id){
        Pernas obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria um novo tipo de perna e cadastra ela no banco de dados")
    @PostMapping
    public ResponseEntity<Pernas> insert(@RequestBody Pernas obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta um tipo de perna através do id dela")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Pernas> update(@PathVariable Long id, @RequestBody Pernas obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
