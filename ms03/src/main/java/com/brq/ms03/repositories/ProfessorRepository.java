package com.brq.ms03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * O primeiro argumento do JpaRepository é a classe modelo para mapear uma tabela
 * e a classe Java
 *
 * O segundo argumento é o tipo de dado da chave primária
 * */
@Repository
public interface ProfessorRepository extends JpaRepository<com.brq.ms03.models.ProfessorModel, Integer> {
}
