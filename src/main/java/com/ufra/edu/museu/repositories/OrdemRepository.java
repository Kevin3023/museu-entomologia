package com.ufra.edu.museu.repositories;

import com.ufra.edu.museu.entities.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<Ordem, Long> {
}
