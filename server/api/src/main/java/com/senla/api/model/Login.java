package com.senla.api.model;

import javax.persistence.*;

/**
 * Class {@code Login} contains data for validation users  {@code Person}
 *
 * @author Ilya Hailov
 * @since 1.00
 */
@Entity
@Table(name = "login")
public class Login {

    /** Id **/
    @Id
    private Long id;

    /** Login **/
    @Column(name = "login")
    private String login;

    /** Password **/
    @Column(name = "pass")
    private String password;

    /** Person**/
    @OneToOne()
    private Person person;
}
