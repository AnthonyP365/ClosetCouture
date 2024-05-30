package com.anthony.closet_couture.controller;

import com.anthony.closet_couture.entity.ClothingItem;
import com.anthony.closet_couture.entity.User;
import com.anthony.closet_couture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @PutMapping("/user/add_clothes/{id}")
    public ResponseEntity<User> addClothingItemToUser(@PathVariable Long id, @RequestBody ClothingItem clothingItem) {
        return new ResponseEntity<>(userService.addClothingItemToUser(id, clothingItem), HttpStatus.OK);
    }

    @DeleteMapping("/user/remove_clothes/{userId}/{clothingItemId}")
    public ResponseEntity<User> removeClothingItemFromUser(@PathVariable Long userId, @PathVariable Long clothingItemId) {
        return new ResponseEntity<>(userService.removeClothingItemFromUser(userId, clothingItemId), HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
