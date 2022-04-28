package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Familia;
import com.ufra.edu.museu.repositories.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return obj.get();
    }

    public Familia insert(Familia obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Familia update(Long id, Familia obj){
        Familia entity = repository.getOne(id);

        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Familia entity, Familia obj) {
        entity.setNome(obj.getNome());
    }
}
