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
    @Column(name = "copy_id")
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

    /** quantity of ordered goods **/
    @Column(name = "quantity")
    private Integer quantity;

}
