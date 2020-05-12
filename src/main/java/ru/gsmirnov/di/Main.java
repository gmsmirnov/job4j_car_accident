package ru.gsmirnov.di;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application entry point. Configures the application, by creating context and registrating dependencies.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-12
 */
public class Main {
    /**
     * The Main.class logger.
     */
    private static final Logger LOG = LogManager.getLogger(Main.class);

    /**
     * Entry point.
     *
     * @param args application params.
     */
    public static void main(String[] args) {
        LOG.info("Application started");

        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Ivan Ivanov");
        ui.add("Petr Petrov");
        ui.print();

        LOG.info("Application finished");
    }
}