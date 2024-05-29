package com.anthony.closet_couture.entity;

import jakarta.persistence.*;

@Entity
public class ClothingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public ClothingItem() {}
    public ClothingItem(String type, User user) {
        this.type = type;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
