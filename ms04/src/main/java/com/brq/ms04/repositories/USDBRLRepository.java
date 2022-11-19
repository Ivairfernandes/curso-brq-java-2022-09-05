package com.brq.ms04.repositories;

import com.brq.ms04.models.USDBRLModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//este comando faz o insert no H2 - console

@Repository
public interface USDBRLRepository
        extends JpaRepository<USDBRLModel, Integer> {
}

