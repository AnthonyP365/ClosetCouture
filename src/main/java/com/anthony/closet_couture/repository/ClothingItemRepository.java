package com.anthony.closet_couture.repository;

import com.anthony.closet_couture.entity.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
}
