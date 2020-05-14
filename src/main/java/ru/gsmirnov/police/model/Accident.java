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
}