package ru.gsmirnov.police.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Acts like a front-controller and is used to dispatch the requests to the appropriate controller methods.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-13
 */
public class WebDesc extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * Specifies the root-config class.
     *
     * @return the instance of the root-config class.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringRootConfig.class };
    }

    /**
     * Specifies Spring MVC Java configuration.
     *
     * @return the instance of the Spring MVC Java configuration
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringWebConfig.class };
    }

    /**
     * Specifies the servlet mappings for the DispatcherServlet
     *
     * @return servlet mappings.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "*.do" };
    }
}