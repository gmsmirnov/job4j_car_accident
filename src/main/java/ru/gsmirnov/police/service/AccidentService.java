package ru.gsmirnov.police.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gsmirnov.police.model.Accident;
import ru.gsmirnov.police.repository.AccidentRepository;

import java.util.List;

/**
 * Business logic related with accident.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-14
 */
@Service
public class AccidentService {
    /**
     * The logger.
     */
    private static final Logger LOG = LogManager.getLogger(AccidentService.class);

    /**
     * The repository. Used to work with DB-accident-entities.
     */
    private final AccidentRepository accidentRepository;

    /**
     * Accident service constructor.
     *
     * @param accidentRepository accident's repository.
     */
    @Autowired
    public AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    /**
     * Gets all accidents. Simply pass them from data layer to controller.
     *
     * @return the list of all accidents.
     */
    public List<Accident> getAllAccidents() {
        return this.accidentRepository.getAllAccidents();
    }
}