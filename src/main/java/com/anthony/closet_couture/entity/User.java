package com.anthony.closet_couture.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ClothingItem> clothingItems;

    public User() {}
    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClothingItem> getClothingItems() {
        return clothingItems;
    }

    public void setClothingItems(List<ClothingItem> clothingItems) {
        this.clothingItems = clothingItems;
    }

    public void addClothingItem(ClothingItem clothingItem) {
        clothingItems.add(clothingItem);
        clothingItem.setUser(this);
    }

    public void removeClothingItem(ClothingItem clothingItem) {
        clothingItems.remove(clothingItem);
        clothingItem.setUser(null);
    }
}
