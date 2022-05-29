package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Pernas;
import com.ufra.edu.museu.repositories.PernasRepository;
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
public class PernasService {

    @Autowired
    private PernasRepository repository;

    public List<Pernas> findAll(){
        return repository.findAll();
    }

    public Pernas findById(Long id){
        Optional<Pernas> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Pernas insert(Pernas obj) {

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

    public Pernas update(Long id, Pernas obj){
        try {
            Pernas entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Pernas entity, Pernas obj) {
        entity.setNome(obj.getNome());
    }
}
