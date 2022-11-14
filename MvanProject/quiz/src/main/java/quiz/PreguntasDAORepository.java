package quiz;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.PreguntasDAO;

public interface PreguntasDAORepository extends JpaRepository<PreguntasDAO, Integer> {
}

// @Repository
// public interface PreguntasDAORepository extends CrudRepository<PreguntasDAO, Integer> { List<PreguntasDAO> findAll(); }
    

