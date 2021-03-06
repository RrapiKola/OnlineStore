package com.example.onlinestore.model;

import com.example.onlinestore.Enumeration.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private  String order_id;

    @Column (nullable = false)
    private String user_name;

    @Column (nullable = false)
    private double total_cost;

    @Column (nullable = false)
    private String delivery_address;

    @Column (nullable = false)
    private String user_address;

    @Column (nullable = false)
    private LocalDateTime date_of_submission;

    //Status

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    @ManyToMany
    @JoinTable(name = "orders_orderLines", joinColumns = @JoinColumn(name = "order_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "order_line_id", nullable = false))
    private List<OrderLine> orderLine;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
