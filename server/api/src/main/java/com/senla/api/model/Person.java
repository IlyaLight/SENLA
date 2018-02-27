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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private List<Address> addresses;

    /** Cars **/
    @ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "car_parson",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id") }
    )
    private List<Car> cars;
}
