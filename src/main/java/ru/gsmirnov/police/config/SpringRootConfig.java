package ru.gsmirnov.police.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Root configuration.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-14
 */
@Configuration
@ComponentScan(basePackages = "ru.gsmirnov.police")
public class SpringRootConfig {
    /**
     * Creates JDBC template to work with the specified data source.
     *
     * @param dataSource the specified data source.
     * @return jdbc template.
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Creates data source to connect to db with the specified params.
     *
     * @return data source with the specified params.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl("jdbc:postgresql://127.0.0.1:5432/car_accident");
        driver.setUsername("postgres");
        driver.setPassword("postgres");
        return driver;
    }
}