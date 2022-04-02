package com.example.onlinestore.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;



@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "role")
    private String role;


    @Override
    public String getAuthority() {
        return role;
    }
}
