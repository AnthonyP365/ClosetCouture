package com.anthony.closet_couture.controller;

import com.anthony.closet_couture.entity.ClothingItem;
import com.anthony.closet_couture.service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClothingItemController {

    @Autowired
    private ClothingItemService clothingItemService;

    @PostMapping("/clothes/add")
    public ClothingItem addClothingItem(ClothingItem clothingItem) {
        return clothingItemService.addClothingItem(clothingItem);
    }

    @GetMapping("/clothes")
    public List<ClothingItem> getAllClothingItems() {
        return clothingItemService.getAllClothingItems();
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<ClothingItem> getClothingItemById(@PathVariable Long id) {
        return new ResponseEntity<>(clothingItemService.getClothingItemById(id), HttpStatus.OK);
    }

    @PutMapping("/clothes/update/{id}")
    public ResponseEntity<ClothingItem> updateClothingItem(@PathVariable Long id, @RequestBody ClothingItem clothingItem) {
        return new ResponseEntity<>(clothingItemService.updateClothingItem(id, clothingItem), HttpStatus.OK);
    }

    @DeleteMapping("/clothes/delete/{id}")
    public void deleteClothingItem(@PathVariable Long id) {
        clothingItemService.deleteClothingItemById(id);
    }
}
