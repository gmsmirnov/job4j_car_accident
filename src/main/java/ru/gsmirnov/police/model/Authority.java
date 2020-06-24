package ru.gsmirnov.police.model;

import lombok.*;

import javax.persistence.*;

/**
 * The authority entity. Describes user's role.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-21
 */
@Table(name = "authorities")
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    /**
     * This authority's identifier.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    /**
     * This authority's name.
     */
    @Column(name = "authority")
    private String authorityName;

    /**
     * The constructor with the specified params.
     *
     * @param authorityName the specified authority name.
     */
    public Authority(String authorityName) {
        this.authorityName = authorityName;
    }
}