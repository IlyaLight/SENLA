package com.senla.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    /** Enum for order status **/
    public enum Status {PROCESSING, SHIPPED, DELIVERED, CANCELED}

    /** Id **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Map of goods and their quantity **/
    @JsonIgnore
    @OneToMany(mappedBy = "order", fetch= FetchType.LAZY)
    private List<OrderedGoods> goods;   //goods and quantity

    /** Total order price **/
    @Column(name = "price")
    private BigDecimal totalPrice;

    /** Buyer **/
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    /** Date of order **/
    @Column(name = "orderDate")
    private LocalDate orderDate;

    /** Order details **/
    @Column(name = "orderDetails")
    private String orderDetails;

    /** Delivery address **/
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    /** Status **/
    @Column(name = "status", columnDefinition = "enum('PROCESSING', 'SHIPPED', 'DELIVERED', 'CANCELED')")
    @Enumerated()
    private Status status;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

