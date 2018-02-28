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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
