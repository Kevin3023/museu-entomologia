package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Metamorfose;
import com.ufra.edu.museu.repositories.MetamorfoseRepository;
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
public class MetamorfoseService {

    @Autowired
    private MetamorfoseRepository repository;

    public List<Metamorfose> findAll(){
        return repository.findAll();
    }

    public Metamorfose findById(Long id){
        Optional<Metamorfose> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Metamorfose insert(Metamorfose obj) {

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

    public Metamorfose update(Long id, Metamorfose obj){
        try {
            Metamorfose entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Metamorfose entity, Metamorfose obj) {
        entity.setTipo_metamorfose(obj.getTipo_metamorfose());
        entity.setDescricao_meta(obj.getDescricao_meta());
    }
}
