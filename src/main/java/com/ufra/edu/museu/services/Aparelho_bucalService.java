package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Aparelho_bucal;
import com.ufra.edu.museu.repositories.Aparelho_bucalRepository;
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
public class Aparelho_bucalService {

    @Autowired
    private Aparelho_bucalRepository repository;

    public List<Aparelho_bucal> findAll(){
        return repository.findAll();
    }

    public Aparelho_bucal findById(Long id){
        Optional<Aparelho_bucal> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Aparelho_bucal insert(Aparelho_bucal obj) {

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

    public Aparelho_bucal update(Long id, Aparelho_bucal obj){
        try {
            Aparelho_bucal entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Aparelho_bucal entity, Aparelho_bucal obj) {
        entity.setNome(obj.getNome());
    }
}
