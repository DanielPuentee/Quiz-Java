package quiz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import quiz.PreguntasDAO;


@Repository
public interface PreguntasDAORepository extends CrudRepository<PreguntasDAO, Integer> {

    List<PreguntasDAO> findAll();

    void saveAll(List<PreguntasDAO> preguntasDAO);

}
    

