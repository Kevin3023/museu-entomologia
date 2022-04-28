package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Ordem;
import com.ufra.edu.museu.repositories.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository repository;

    public List<Ordem> findAll(){
        return repository.findAll();
    }

    public Ordem findById(Long id){
        Optional<Ordem> obj = repository.findById(id);

        return obj.get();
    }

    public Ordem insert(Ordem obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Ordem update(Long id, Ordem obj){
        Ordem entity = repository.getOne(id);

        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Ordem entity, Ordem obj) {
        entity.setNome(obj.getNome());
    }
}
