package ru.gsmirnov.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User interface, which provides the work of application.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-12
 */
@Component
public class StartUI {
    /**
     * The storage to store requests.
     */
    @Autowired
    private Store store;

    /**
     * The input.
     */
    private Input input;

    /**
     * Sets the specified input.
     *
     * @param input the specified input.
     */
    @Autowired
    public void setInput(Input input) {
        this.input = input;
    }

    /**
     * Adds a new request to the storage.
     *
     * @param value the specified request.
     */
    public void add(String value) {
        this.store.add(value);
    }

    /**
     * Shows all requests.
     */
    public void print() {
        for (String value : this.store.getAll()) {
            System.out.println(value);
        }
    }
}