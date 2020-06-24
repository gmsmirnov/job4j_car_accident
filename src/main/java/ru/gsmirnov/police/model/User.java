package ru.gsmirnov.police.model;

import lombok.*;

import javax.persistence.*;

/**
 * The user entity. Describes a user for car accident application.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-21
 */
@Table(name = "users")
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * This user's identifier.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    /**
     * This user's name.
     */
    @Column(name = "username")
    private String name;

    /**
     * This user's password in encoded form.
     */
    @Column(name = "password")
    @EqualsAndHashCode.Exclude
    private String password;

    /**
     * The flag which shows is this user enabled or not.
     */
    @Column(name = "enabled")
    @EqualsAndHashCode.Exclude
    private boolean enabled;

    /**
     * This user's authority.
     */
    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;

    /**
     * The constructor with the specified params.
     *
     * @param name the specified user name.
     * @param encodedPassword the specified user password (encoded).
     * @param isEnable is user enabled or disabled.
     * @param authority the user role.
     */
    public User(String name, String encodedPassword, boolean isEnable, Authority authority) {
        this.name = name;
        this.password = encodedPassword;
        this.enabled = isEnable;
        this.authority = authority;
    }
}