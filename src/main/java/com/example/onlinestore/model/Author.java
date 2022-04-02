package com.example.onlinestore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> product;


}
