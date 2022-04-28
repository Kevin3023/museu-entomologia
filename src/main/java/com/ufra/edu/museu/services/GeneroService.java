package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Genero;
import com.ufra.edu.museu.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository repository;

    public List<Genero> findAll(){
        return repository.findAll();
    }

    public Genero findById(Long id){
        Optional<Genero> obj = repository.findById(id);

        return obj.get();
    }

    public Genero insert(Genero obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Genero update(Long id, Genero obj){
        Genero entity = repository.getOne(id);

        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Genero entity, Genero obj) {
        entity.setNome(obj.getNome());
    }
}
