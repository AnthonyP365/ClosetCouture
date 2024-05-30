package com.anthony.closet_couture.service;

import com.anthony.closet_couture.entity.ClothingItem;
import com.anthony.closet_couture.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    User addClothingItemToUser(Long id, ClothingItem clothingItem);
    User removeClothingItemFromUser(Long userId, Long clothingItemId);
    void deleteUserById(Long id);
}
