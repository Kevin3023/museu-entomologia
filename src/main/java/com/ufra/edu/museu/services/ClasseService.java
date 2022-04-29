package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Classe;
import com.ufra.edu.museu.repositories.ClasseRepository;
import com.ufra.edu.museu.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository repository;

    public List<Classe> findAll(){
        return repository.findAll();
    }

    public Classe findById(Long id){
        Optional<Classe> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Classe insert(Classe obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Classe update(Long id, Classe obj){
        Classe entity = repository.getOne(id);

        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Classe entity, Classe obj) {
        entity.setNome(obj.getNome());
    }
}
