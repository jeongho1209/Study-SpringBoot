package com.example.jpql.entity;

import com.example.jpql.entity.column.Address;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_orders")
public class Orders {

    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
