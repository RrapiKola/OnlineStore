package com.example.onlinestore.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private String id;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false)
    private String city;

    @Column (nullable = false)
    private String address;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<RoleEntity> Role;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
    private List<OrderEntity> orderEntityList;




}
