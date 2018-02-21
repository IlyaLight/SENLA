package com.senla.api.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Class {@code Cart} serves to store a list of buyer's goods
 *
 * @author Ilya Hailov
 * @since 1.00
 */
public class Cart {
    /** Id **/
    private Long id;
    /** Goods, Map serves to store a list of buyer's goods, key: goods, value: quantity **/
    private Map<Goods,Integer> goods;
    /** Total price of goods in cart **/
    private BigDecimal totalPrice;
    /** Buyer reference**/
    private Person person;
}
