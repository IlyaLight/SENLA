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
    @Column(name = "status", length = 25)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderedGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderedGoods> goods) {
        this.goods = goods;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

