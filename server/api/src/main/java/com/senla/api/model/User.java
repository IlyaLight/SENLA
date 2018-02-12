package com.senla.api.model;

import javax.persistence.*;

@Entity
@Table(name = "uaer_detail")
public class User implements IModel {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", length = 25)
    private String userName;

    @Column(name = "email", length = 25)
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return null;
    }

    public void setId(Integer id) {

    }
}
