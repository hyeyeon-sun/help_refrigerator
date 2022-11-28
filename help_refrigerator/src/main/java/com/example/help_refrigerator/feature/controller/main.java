package com.example.help_refrigerator.feature.controller;

import com.example.help_refrigerator.feature.dto.GetFoodDto;
import com.example.help_refrigerator.feature.dto.PostFoodDto;
import com.example.help_refrigerator.feature.dto.PostFoodManualDto;
import com.example.help_refrigerator.feature.dto.PutFoodDto;
import com.example.help_refrigerator.feature.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/api")
public class main {

    @Autowired
    private final FoodService foodService;

    public main(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public List<GetFoodDto> getAllFoods(){
        return foodService.getAllFoods();
    }

    @GetMapping("/foods/{period}")
    public List<GetFoodDto> getFoodsByPeriod(@PathVariable(name = "period") Integer period){
        return foodService.getFoodsByPeriod(period);
    }

    @GetMapping("/food/{foodId}")
    public GetFoodDto getFoodById(@PathVariable(name = "foodId") Integer foodId){
        return foodService.getFoodById(foodId);
    }

    @PostMapping("/food")
    public GetFoodDto addFood(@RequestBody PostFoodDto dto){
        return foodService.addFood(dto);
    }

    @PutMapping("/food")
    public GetFoodDto modifyFoodById(@RequestBody PutFoodDto dto){
        return foodService.modifyFood(dto);
    }

    @DeleteMapping("/food/{foodId}")
    public String deleteFoodById(@PathVariable(name = "foodId") Integer foodId){
        return foodService.deleteFood(foodId);
    }

    @PostMapping("/food/manual")
    public GetFoodDto addFoodByManual(@RequestBody PostFoodManualDto dto){
        return foodService.addFoodByManual(dto);
    }

}
