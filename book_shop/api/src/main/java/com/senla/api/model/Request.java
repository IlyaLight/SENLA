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

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
