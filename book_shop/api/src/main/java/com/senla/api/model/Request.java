package com.senla.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Light on 22.09.2017.
 */
@Entity(name = "request")
public class Request implements Serializable, IModel {
    private static final long serialVersionUID = 5137060325723194962L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
    @Column(name = "quantity")
    private Integer quantity;
    private static final String FORMAT_TO_STRING = "Book Name: %s, Quantity: %d";

    public Request() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return String.format(FORMAT_TO_STRING, quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
