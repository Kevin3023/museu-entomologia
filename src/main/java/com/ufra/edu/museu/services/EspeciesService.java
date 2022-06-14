package com.ufra.edu.museu.services;

import com.ufra.edu.museu.entities.Especies;
import com.ufra.edu.museu.repositories.EspeciesRepository;
import com.ufra.edu.museu.services.exceptions.DatabaseException;
import com.ufra.edu.museu.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EspeciesService {

    @Autowired
    private EspeciesRepository repository;

    public List<Especies> findAll(){
        return repository.findAll();
    }

    public Page<Especies> listaPaginada(Pageable pageable) {

        return repository.findAll(pageable);
    }

    public List<Especies> findByName(String name) {

        return repository.findByName(name.toLowerCase());
    }

    public Especies findById(Long id){
        Optional<Especies> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Especies insert(Especies obj) {

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

    public Especies update(Long id, Especies obj){
        try {
            Especies entity = repository.getOne(id);

            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Especies entity, Especies obj) {
        entity.setNome_comum(obj.getNome_comum());
        entity.setNome_cientifico(obj.getNome_cientifico());
        entity.setImage_id(obj.getImage_id());
        entity.setImage_url(obj.getImage_url());
        entity.setAbdomen(obj.getAbdomen());
        entity.setAntenas(obj.getAntenas());
        entity.setAsas(obj.getAsas());
        entity.setAparelho_bucal(obj.getAparelho_bucal());
        entity.setClasse(obj.getClasse());
        entity.setComportamento(obj.getComportamento());
        entity.setCuriosidades(obj.getCuriosidades());
        entity.setFamilia(obj.getFamilia());
        entity.setFilo(obj.getFilo());
        entity.setGenero(obj.getGenero());
        entity.setHabitat(obj.getHabitat());
        entity.setMetamorfose(obj.getMetamorfose());
        entity.setOrdem(obj.getOrdem());
        entity.setPernas(obj.getPernas());
    }

}
