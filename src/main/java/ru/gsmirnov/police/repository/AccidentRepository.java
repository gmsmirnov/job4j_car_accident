package ru.gsmirnov.police.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gsmirnov.police.model.Accident;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The repository to work with accident-entities in database. Provides CRUD-methods.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-14
 */
@Repository
public class AccidentRepository {
    /**
     * The logger.
     */
    private static final Logger LOG = LogManager.getLogger(AccidentRepository.class);

    /**
     *  The JDBC template which simplifies the use of JDBC.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * The accident repository constructor.
     *
     * @param jdbcTemplate the JDBC template which simplifies the use of JDBC.
     */
    @Autowired
    public AccidentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gets the list of all accidents from database.
     *
     * @return the list of all accidents stored in database.
     */
    public List<Accident> getAllAccidents() {
        String sql = "SELECT id, acc_name, text, address FROM accident";
        return this.jdbcTemplate.query(sql, new AccidentRowMapper());
    }

    /**
     * The accident row mapper. It used to convert DB-accident-row into java-accident-object.
     *
     * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
     * @version 0.1
     * @since 2020-05-14
     */
    static class AccidentRowMapper implements RowMapper<Accident> {
        /**
         * Transforms DB-accident-row into java-accident-object.
         *
         * @param resultSet query result obtained from database.
         * @param rowNum row number.
         * @return A java-accident-object.
         * @throws SQLException if any SQL problems occurs.
         */
        @Override
        public Accident mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Accident(
                    resultSet.getInt("id"),
                    resultSet.getString("acc_name"),
                    resultSet.getString("text"),
                    resultSet.getString("address")
            );
        }
    }
}