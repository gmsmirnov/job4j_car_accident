package ru.gsmirnov.police.model;

import lombok.*;

/**
 * Accident model. Describes the possible accident by specifying its type, description and address.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-13
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Accident {
    /**
     * This accident's id.
     */
    @EqualsAndHashCode.Exclude
    private int id;

    /**
     * This accident's name (type).
     */
    private String name;

    /**
     * This accident's description.
     */
    private String text;

    /**
     * This accident's address.
     */
    private String address;

    /**
     * Creates a new Accident with the specified params
     *
     * @param name the specified accident's type.
     * @param text the specified accident's description.
     * @param address the specified accident's address.
     */
    public Accident(String name, String text, String address) {
        this.name = name;
        this.text = text;
        this.address = address;
    }
}