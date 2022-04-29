package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Ordem;
import com.ufra.edu.museu.repositories.OrdemRepository;
import com.ufra.edu.museu.services.exceptions.DatabaseException;
import com.ufra.edu.museu.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Ordem insert(Ordem obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

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
