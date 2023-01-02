package com.example.jpql.entity.column;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;

    private String street;

    private String zipCode;

}
