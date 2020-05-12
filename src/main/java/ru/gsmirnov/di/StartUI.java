package ru.gsmirnov.di;

/**
 * User interface, which provides the work of application.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-12
 */
public class StartUI {
    /**
     * The storage to store requests.
     */
    private Store store;

    /**
     * The input.
     */
    private Input input;

    /**
     * The constructor. Creates user interface with the specified storage.
     *
     * @param store the specified storage.
     */
    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
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