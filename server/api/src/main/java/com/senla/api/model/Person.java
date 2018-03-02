package com.senla.api.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Class {@code Person} describes buyers and sellers, depending on the status
 *
 * @author Ilya Hailov
 * @since 1.00
 */
@Entity
@Table(name = "person")
public class Person {

    /** Id **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name **/
    @Column(name = "name")
    private String name;

    /** Status **/
    @Column(name = "status")
    private String status;

    /** Email **/
    @Column(name = "email")
    private String email;

    /** Indicates whether the account is active **/
    @Column(name = "active")
    private Boolean active;

    /** Login data **/
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Login login;

    /** Orders list **/
    @OneToMany(mappedBy = "person", fetch=FetchType.LAZY)
    private List<Order> orders;

    /** Cart **/
    @ElementCollection
    @CollectionTable(name = "cart",
            joinColumns = @JoinColumn(name = "person_id"))
    @MapKeyJoinColumn(name = "goods_id")
    @Column(name = "quantity")
    private Map<Goods,Integer> cart;

    /** Delivery address list **/
    @OneToMany(mappedBy = "person", fetch=FetchType.LAZY)
    private List<Address> addres;

    /** Cars **/
    @ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "car_parson",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id") }
    )
    private List<Car> cars;

    public Person() {
    }

    public Person(String name, String status, String email, Boolean active, Login login) {
        this.name = name;
        this.status = status;
        this.email = email;
        this.active = active;
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Map<Goods, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Goods, Integer> cart) {
        this.cart = cart;
    }

    public List<Address> getAddres() {
        return addres;
    }

    public void setAddres(List<Address> addres) {
        this.addres = addres;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
