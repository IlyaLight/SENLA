package com.senla.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Class {@code OrderedGoods} contains description of ordered goods copied from {@code Goods}
 * when making a order {@code Ordered}
 *
 * @author Ilya Hailov
 * @since 1.00
 */
@Entity
@Table(name = "ordered_goods")
public class OrderedGoods {

    /** Id **/
    @Id
    private Long id;

    /** Copy id **/
    @Column(name = "copy_id")
    private Long copyId;

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

    /** Quantity of ordered goods **/
    @Column(name = "quantity")
    private Integer quantity;

    /** Order **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    /** Original goods **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Goods goods;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
