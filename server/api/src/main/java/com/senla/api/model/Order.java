package com.senla.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Class {@code Order} describes the customer's order
 *
 * @author Ilya Hailov
 * @since 1.00
 */
@Entity
@Table(name = "_order_")
public class Order {

    /** Id **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Map of goods and their quantity **/
    @OneToMany(mappedBy = "order", fetch= FetchType.LAZY)
    private List<OrderedGoods> goods;   //goods and quantity

    /** Total order price **/
    @Column(name = "price")
    private BigDecimal totalPrice;

    /** Buyer **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    /** Date of order **/
    @Column(name = "orderDate")
    private LocalDate orderDate;

    /** Order details **/
    @Column(name = "orderDetails", length = 25)
    private String orderDetails;

    /** Delivery address **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    /** Status **/
    @Column(name = "orderDetails", length = 25)
    private String status;
}

