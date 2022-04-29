package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Familia;
import com.ufra.edu.museu.repositories.FamiliaRepository;
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
public class FamiliaService {

    @Autowired
    private FamiliaRepository repository;

    public List<Familia> findAll(){
        return repository.findAll();
    }

    public Familia findById(Long id){
        Optional<Familia> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Familia insert(Familia obj) {
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

    public Familia update(Long id, Familia obj){
        try {
            Familia entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Familia entity, Familia obj) {
        entity.setNome(obj.getNome());
    }
}
