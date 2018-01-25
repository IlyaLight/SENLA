package com.senla.api.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Light on 22.09.2017.
 */
@Entity
@Table(name = "book")
public class Book implements Serializable, IModel {

    private static final long serialVersionUID = 8605912397965468121L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Expose
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Order> orderArrayList;

    @Expose
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Request> requests;

    @Column(name = "name", length = 100)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_publication")
    private Date datePublication;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_issue")
    private Date dateIssue;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "in_stock")
    private int inStock;
    private static final String FORMAT_TO_STRING = "Name: %s, Date of Publication: %s, Data Of Issue: %s, Price: %f, In Stock: %d";

    public Book() {
    }

    public Book(String name, Date dateOfIssue, Date datePublication, Float price, int inStock) {
        this.name = name;
        this.dateIssue = dateOfIssue;
        this.datePublication = datePublication;
        this.price = price;
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @Override
    public String toString(){
        return String.format(FORMAT_TO_STRING, name, datePublication.toString(),  dateIssue.toString(), price, inStock );
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setPrice(Double price) {
        this.price = price.floatValue();
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

}
