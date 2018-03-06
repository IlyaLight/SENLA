package com.senla.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Class {@code Address} contains the parameters of the share
 * of storage of customer {@code Person} addresses
 *
 * @author Ilya Hailov
 * @since 1.00
 */
@Entity
@Table(name = "address")
public class Address {

    /** Id **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**  City **/
    @Column(name = "city")
    private String city;

    /** Address (strit, house, flat) **/
    @Column(name = "address")
    private String address;

    /** Post Code **/
    @Column(name = "postCode")
    private Integer postCode;

    /** Person **/
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    /** All orders from the buyer {@code person} at this address **/
    @JsonIgnore
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
