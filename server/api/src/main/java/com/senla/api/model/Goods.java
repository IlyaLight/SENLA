package com.senla.api.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "car_goods",
            joinColumns = { @JoinColumn(name = "goods_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id") }
    )
    private List<Car> cars;

}
