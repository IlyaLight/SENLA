package com.senla.api.model;

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
@Table(name = "addres")
public class Address {

    /** Id **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**  City **/
    @Column(name = "city", length = 25)
    private String city;

    /** Address (strit, house, flat) **/
    @Column(name = "addres", length = 25)
    private String addres;

    /** postCode **/
    @Column(name = "addres", length = 25)
    private Integer postCode;

    /** Person **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    /** All orders from the buyer {@code person} at this address **/
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Order> orders;
}
