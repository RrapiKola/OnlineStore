package com.example.onlinestore.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private String id;

    @Column (nullable = false)

    private String role_name;


    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> userEntityList;



}
