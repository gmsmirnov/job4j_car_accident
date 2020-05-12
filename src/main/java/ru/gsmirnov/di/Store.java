package ru.gsmirnov.di;

import java.util.ArrayList;
import java.util.List;

/**
 * A storage description.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-12
 */
public class Store {
    /**
     * The storage to store requests.
     */
    private List<String> data = new ArrayList<String>();

    /**
     * Adds a new request to the storage.
     *
     * @param value the specified request.
     */
    public void add(String value) {
        this.data.add(value);
    }

    /**
     * Gets all requests from the storage.
     *
     * @return all requests from the storage.
     */
    public List<String> getAll() {
        return this.data;
    }
}