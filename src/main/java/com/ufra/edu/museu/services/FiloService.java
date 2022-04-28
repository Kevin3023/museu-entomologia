package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Filo;
import com.ufra.edu.museu.repositories.FiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return obj.get();
    }

    public Filo insert(Filo obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Filo update(Long id, Filo obj){
        Filo entity = repository.getOne(id);

        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Filo entity, Filo obj) {
        entity.setNome(obj.getNome());
    }
}
