package com.example.help_refrigerator.feature.persistance;

import com.example.help_refrigerator.feature.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FoodRepo extends JpaRepository<Food, Integer> {
    Optional<Food> findById(Integer foodId);
    List<Food> findAll();
    List<Food> findByExpirationDateBetweenOrderByExpirationDate(Date start, Date end);

    Optional<Food> findByImageUrl(String url);

    @Transactional
    void deleteFoodByFoodId(Integer id);
}
