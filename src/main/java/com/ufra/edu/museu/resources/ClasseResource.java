package com.ufra.edu.museu.resources;

import com.ufra.edu.museu.entities.Classe;
import com.ufra.edu.museu.services.ClasseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/classes")
public class ClasseResource {

    @Autowired
    private ClasseService service;

    @ApiOperation(value = "Recupera todos os registros de classes")
    @GetMapping
    public ResponseEntity<List<Classe>> findAll(){

        List<Classe> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Recupera um registro de classe por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Classe> findById(@PathVariable Long id){
        Classe obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria uma nova classe e cadastra ela no banco de dados")
    @PostMapping
    public ResponseEntity<Classe> insert(@RequestBody Classe obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Deleta uma classe através do id dela")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um registro no banco de dados através do id dele")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Classe> update(@PathVariable Long id, @RequestBody Classe obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
