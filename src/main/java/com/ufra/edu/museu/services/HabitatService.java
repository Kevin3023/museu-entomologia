package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Habitat;
import com.ufra.edu.museu.repositories.HabitatRepository;
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
public class HabitatService {

    @Autowired
    private HabitatRepository repository;

    public List<Habitat> findAll(){
        return repository.findAll();
    }

    public Habitat findById(Long id){
        Optional<Habitat> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Habitat insert(Habitat obj) {

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

    public Habitat update(Long id, Habitat obj){
        try {
            Habitat entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Habitat entity, Habitat obj) {
        entity.setNome(obj.getNome());
    }
}
