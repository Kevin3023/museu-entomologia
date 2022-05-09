package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Antenas;
import com.ufra.edu.museu.entities.Antenas;
import com.ufra.edu.museu.repositories.AntenasRepository;
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
public class AntenasService {

    @Autowired
    private AntenasRepository repository;

    public List<Antenas> findAll(){
        return repository.findAll();
    }

    public Antenas findById(Long id){
        Optional<Antenas> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Antenas insert(Antenas obj) {

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

    public Antenas update(Long id, Antenas obj){
        try {
            Antenas entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Antenas entity, Antenas obj) {
        entity.setNome_antena(obj.getNome_antena());
    }
}
