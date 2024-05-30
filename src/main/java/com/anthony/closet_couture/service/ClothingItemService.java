package com.anthony.closet_couture.service;

import com.anthony.closet_couture.entity.ClothingItem;

import java.util.List;

public interface ClothingItemService {
    ClothingItem addClothingItem(ClothingItem clothingItem);
    List<ClothingItem> getAllClothingItems();
    ClothingItem getClothingItemById(Long id);
    ClothingItem updateClothingItem(Long id, ClothingItem clothingItem);
    void deleteClothingItemById(Long id);
}
