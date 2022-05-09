package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Comportamento;
import com.ufra.edu.museu.repositories.ComportamentoRepository;
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
public class ComportamentoService {

    @Autowired
    private ComportamentoRepository repository;

    public List<Comportamento> findAll(){
        return repository.findAll();
    }

    public Comportamento findById(Long id){
        Optional<Comportamento> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Comportamento insert(Comportamento obj) {

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

    public Comportamento update(Long id, Comportamento obj){
        try {
            Comportamento entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Comportamento entity, Comportamento obj) {
        entity.setTipo_comportamento(obj.getTipo_comportamento());
    }
}
