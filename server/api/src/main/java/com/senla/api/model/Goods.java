package com.senla.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Class {@code Goods} contains parameters describing the goods
 *
 * @author Ilya Hailov
 * @since 1.00
 */
@Entity
@Table(name = "goods")
public class Goods {

    /** Id **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name **/
    @Column(name = "name")
    private String name;

    /** Image link **/
    @Column(name = "img_link")
    private String imgLink;

    /** To which group goods belongs **/
    @Column(name = "category")
    private String category;

    /** Description **/
    @Column(name = "description")
    private String description;

    /** Characteristics **/
    @Column(name = "characteristics")
    private String characteristics;

    /** Price **/
    @Column(name = "price")
    private BigDecimal price;

    /** Number of units available **/
    @Column(name = "in_stock")
    private Integer inStock;

    /** Compatible car **/
    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "car_goods",
            joinColumns = { @JoinColumn(name = "goods_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id") }
    )
    private List<Car> cars;

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

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
