package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Filo;
import com.ufra.edu.museu.repositories.FiloRepository;
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
public class FiloService {

    @Autowired
    private FiloRepository repository;

    public List<Filo> findAll(){
        return repository.findAll();
    }

    public Filo findById(Long id){
        Optional<Filo> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Filo insert(Filo obj) {
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

    public Filo update(Long id, Filo obj){
        try {
            Filo entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Filo entity, Filo obj) {
        entity.setNome(obj.getNome());
    }
}
