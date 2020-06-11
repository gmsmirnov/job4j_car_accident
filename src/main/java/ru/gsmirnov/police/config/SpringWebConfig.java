package ru.gsmirnov.police.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring MVC Java configuration.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-14
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "ru.gsmirnov.police")
public class SpringWebConfig extends WebMvcConfigurationSupport {
    /**
     * Resolves the provided URI to actual URI.
     * Using this configuration, if URI /accidents is requested, DispatcherServlet will forward the request
     * to the prefix + viewname + suffix = /WEB-INF/views/accidents.jsp.
     *
     * @return initialized view resolver.
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}