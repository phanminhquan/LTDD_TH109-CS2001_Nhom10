package com.example.orderfoodapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
@Table(name = "user_uudai")
public class UserUudai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Id_UuDai")
    private Uudai uudai;

}
