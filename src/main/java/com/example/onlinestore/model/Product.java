package com.example.onlinestore.model;

import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    private Double price;

    @Enumerated(EnumType.ORDINAL)
    private ProductType productType;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    private OrderLine orderLine;

}
