package com.example.help_refrigerator.feature.persistance;

import com.example.help_refrigerator.feature.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodCategoryRepo extends JpaRepository<FoodCategory, Integer> {
    Optional<FoodCategory> findById(Integer foodId);
}
