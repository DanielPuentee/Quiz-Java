package com.quiz.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.model.PreguntasDAO;

@Repository
public interface PreguntasDAORepository extends JpaRepository<PreguntasDAO, Integer> {

}

// @Repository
// public interface PreguntasDAORepository extends CrudRepository<PreguntasDAO, Integer> { List<PreguntasDAO> findAll(); }
    

