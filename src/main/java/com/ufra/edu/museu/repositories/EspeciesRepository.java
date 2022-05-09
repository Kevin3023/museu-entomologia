package com.ufra.edu.museu.repositories;

import com.ufra.edu.museu.entities.Especies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspeciesRepository extends JpaRepository<Especies, Long> {
}
