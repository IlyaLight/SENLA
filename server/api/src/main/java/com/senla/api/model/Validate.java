package com.senla.api.model;

import javax.persistence.*;

@Entity
@Table(name = "user_validate")
public class Validate implements IModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "login", length = 25)
    private String login;

    @Column(name = "pass", length = 25)
    private String pass;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }
}
