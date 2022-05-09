package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Asas;
import com.ufra.edu.museu.repositories.AsasRepository;
import com.ufra.edu.museu.services.exceptions.DatabaseException;
import com.ufra.edu.museu.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AsasService {

    private AsasRepository repository;

    public List<Asas> findAll(){
        return repository.findAll();
    }

    public Asas findById(Long id){
        Optional<Asas> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Asas insert(Asas obj) {

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

    public Asas update(Long id, Asas obj){
        try {
            Asas entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Asas entity, Asas obj) {
        entity.setNome_asa(obj.getNome_asa());
    }
}
