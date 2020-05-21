package ru.gsmirnov.police.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gsmirnov.police.model.Accident;

import java.util.List;

/**
 * The repository to work with accident-entities in database. Provides CRUD-methods.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-14
 */
@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    /**
     * Gets the list of all accidents from database.
     *
     * @return the list of all accidents stored in database.
     */
    List<Accident> findAll();
}