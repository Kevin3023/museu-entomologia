package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Abdomen;
import com.ufra.edu.museu.repositories.AbdomenRepository;
import com.ufra.edu.museu.services.exceptions.DatabaseException;
import com.ufra.edu.museu.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AbdomenService {

    @Autowired
    private AbdomenRepository repository;

    public List<Abdomen> findAll(){

        return repository.findAll();
    }

    public Abdomen findById(Long id){
        Optional<Abdomen> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Abdomen insert(Abdomen obj) {

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

    public Abdomen update(Long id, Abdomen obj){
        try {
            Abdomen entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Abdomen entity, Abdomen obj) {
        entity.setNome_abdomen(obj.getNome_abdomen());
    }
}
