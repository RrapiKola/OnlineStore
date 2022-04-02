package com.example.onlinestore.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="order_lines")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="number_of_products")
    private Integer numberOfProducts;

    @Column(name="price")
    private Double price;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> product;


}
