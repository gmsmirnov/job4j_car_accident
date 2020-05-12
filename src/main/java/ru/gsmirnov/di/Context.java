package ru.gsmirnov.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Application context. Stores and registers dependencies.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-12
 */
public class Context {
    /**
     * Dependency storage.
     */
    private Map<String, Object> els = new HashMap<String, Object>();

    /**
     * Registers a new dependency.
     *
     * @param cl a new dependency.
     * @throws IllegalStateException if the specified class has more than one constructor, or this dependency is already exists in the storage,
     * or some problems with creating dependency instance happened.
     */
    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException(String.format("Class has multiple constructors: %s", cl.getCanonicalName()));
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<Object>();
        for (Class arg : con.getParameterTypes()) {
            if (!this.els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException(String.format("Object doesn't found in context: %s", arg.getCanonicalName()));
            }
            args.add(this.els.get(arg.getCanonicalName()));
        }
        try {
            this.els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new IllegalStateException(String.format("Couldn't create an instance of: %s", cl.getCanonicalName()), e);
        }
    }

    /**
     * Gets dependency instance by class name.
     *
     * @param inst required dependency.
     * @param <T> type of required dependency.
     * @return the instance of required dependency.
     */
    public <T> T get(Class<T> inst) {
        return (T) this.els.get(inst.getCanonicalName());
    }
}