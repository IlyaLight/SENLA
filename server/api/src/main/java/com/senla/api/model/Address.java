package com.senla.api.model;

/**
 * Class {@code Address} contains the parameters of the share
 * of storage of customer {@code Person} addresses
 *
 * @author Ilya Hailov
 * @since 1.00
 */

public class Address {
    /** Address id **/
    private Long id;
    /**  City **/
    private String city;
    /** Address (strit, house, flat) **/
    private String addres;
    /** PostCode **/
    private Integer postCode;
    /** Address id **/
    private Person person;
}
