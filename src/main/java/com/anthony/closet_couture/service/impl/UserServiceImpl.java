package com.anthony.closet_couture.service.impl;

import com.anthony.closet_couture.entity.ClothingItem;
import com.anthony.closet_couture.entity.User;
import com.anthony.closet_couture.exception.ResourceNotFoundException;
import com.anthony.closet_couture.repository.UserRepository;
import com.anthony.closet_couture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setName(user.getName());
            return userRepository.save(updatedUser);
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    @Override
    public User addClothingItemToUser(Long id, ClothingItem clothingItem) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.addClothingItem(clothingItem);
            return userRepository.save(updatedUser);
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    @Override
    public User removeClothingItemFromUser(Long userId, Long clothingItemId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            for (ClothingItem c : user.getClothingItems()) {
                if (c.getId().equals(clothingItemId)) {
                    user.removeClothingItem(c);
                }
            }
            return userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
