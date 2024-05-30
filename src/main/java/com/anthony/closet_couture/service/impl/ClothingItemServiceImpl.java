package com.anthony.closet_couture.service.impl;

import com.anthony.closet_couture.entity.ClothingItem;
import com.anthony.closet_couture.exception.ResourceNotFoundException;
import com.anthony.closet_couture.repository.ClothingItemRepository;
import com.anthony.closet_couture.service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClothingItemServiceImpl implements ClothingItemService {

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    @Override
    public ClothingItem addClothingItem(ClothingItem clothingItem) {
        return clothingItemRepository.save(clothingItem);
    }

    @Override
    public List<ClothingItem> getAllClothingItems() {
        return clothingItemRepository.findAll();
    }

    @Override
    public ClothingItem getClothingItemById(Long id) {
        Optional<ClothingItem> optionalClothingItem = clothingItemRepository.findById(id);
        if (optionalClothingItem.isPresent()) {
            return optionalClothingItem.get();
        } else {
            throw new ResourceNotFoundException("Clothing item not found");
        }
    }

    @Override
    public ClothingItem updateClothingItem(Long id, ClothingItem clothingItem) {
        Optional<ClothingItem> optionalClothingItem = clothingItemRepository.findById(id);
        if (optionalClothingItem.isPresent()) {
            ClothingItem updatedClothingItem = optionalClothingItem.get();
            updatedClothingItem.setType(clothingItem.getType());
            return clothingItemRepository.save(updatedClothingItem);
        } else {
            throw new ResourceNotFoundException("Clothing item not found");
        }
    }

    @Override
    public void deleteClothingItemById(Long id) {
        clothingItemRepository.deleteById(id);
    }
}
