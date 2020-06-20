package ru.gsmirnov.police.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Authentication config.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

    /**
     * Data source for connecting to database.
     */
    private DataSource dataSource;

    /**
     * SecurityConfig constructor. Injects data source.
     *
     * @param dataSource specified in properties datasource.
     */
    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Describes how to find users. This time user are stored in memory. Each user has a role and password, also stored in memory.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority From authorities WHERE username = ?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * Describes resources access by user roles.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login")
                    .permitAll()
                .antMatchers("/**")
                    .hasAnyRole("USER", "ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login.do")
//                    .defaultSuccessUrl("/")
                    .failureUrl("/login.do?error=true")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/login.do?logout=true")
                    .invalidateHttpSession(true)
                    .permitAll()
                .and()
                    .csrf()
                    .disable();
    }
}
