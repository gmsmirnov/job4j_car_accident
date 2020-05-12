package ru.gsmirnov.di;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Application entry point. Configures the application, by creating context and registrating dependencies.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-12
 */
public class SpringDI {
    /**
     * The SpringDI.class logger.
     */
    private static final Logger LOG = LogManager.getLogger(SpringDI.class);

    /**
     * Entry point.
     *
     * @param args application params.
     */
    public static void main(String[] args) {
        LOG.info("Application started");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.gsmirnov.di");
        context.refresh();
        LOG.info("Context initialized.");

        StartUI ui = context.getBean(StartUI.class);
        ui.add("Ivan Ivanov");
        ui.add("Petr Petrov");
        ui.print();

        StartUI anotherUI = context.getBean(StartUI.class);
        anotherUI.print();

        LOG.info("Application finished");
    }
}