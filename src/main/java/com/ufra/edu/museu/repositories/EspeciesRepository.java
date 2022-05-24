package com.ufra.edu.museu.repositories;

import com.ufra.edu.museu.entities.Especies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EspeciesRepository extends JpaRepository<Especies, Long> {

    @Query(
            value = "SELECT * FROM especies WHERE LOWER(nome_cientifico) Like %?1% OR LOWER(nome_comum) like '%?1%';",
            nativeQuery = true)
    List<Especies> findByName(String name);
}
