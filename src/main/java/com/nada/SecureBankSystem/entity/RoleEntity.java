package com.nada.SecureBankSystem.entity;

import com.nada.SecureBankSystem.util.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity {



    @Id // this indicates that I assigned the id to be my primary key
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Roles title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Roles getTitle() {
        return title;
    }

    public void setTitle(Roles roles) {
        this.title = roles;
    }
}
