package com.example.help_refrigerator.feature.service;

import com.example.help_refrigerator.feature.domain.Food;
import com.example.help_refrigerator.feature.domain.FoodCategory;
import com.example.help_refrigerator.feature.dto.GetFoodDto;
import com.example.help_refrigerator.feature.dto.PostFoodDto;
import com.example.help_refrigerator.feature.dto.PostFoodManualDto;
import com.example.help_refrigerator.feature.persistance.FoodCategoryRepo;
import com.example.help_refrigerator.feature.persistance.FoodRepo;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private final FoodRepo foodRepo;
    @Autowired
    private final FoodCategoryRepo foodCategoryRepo;

    public FoodService(FoodRepo foodRepo, FoodCategoryRepo foodCategoryRepo) {
        this.foodRepo = foodRepo;
        this.foodCategoryRepo = foodCategoryRepo;
    }


    public List<GetFoodDto> getAllFoods(){
        List<Food> foods = foodRepo.findAll();

        List<GetFoodDto> collect = foods.stream()
                .map(m-> new GetFoodDto(m.getFoodId(), m.getCategoryId(), m.getName(), m.getExpirationDate(), m.getImageUrl(), m.getCreated_at()))
                .collect(Collectors.toList());

        return collect;
    }

    public List<GetFoodDto> getFoodsByPeriod(Integer period){

        try{
            Date today = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String format = formatter.format(today);

            Calendar cal = Calendar.getInstance();
            Date todayCal = new SimpleDateFormat("yyyy-MM-dd").parse(format);
            cal.setTime(todayCal);

            cal.add(Calendar.DATE, 0);
            String endDay = formatter.format(cal.getTime());
            cal.add(Calendar.DATE, period);
            String startDay = formatter.format(cal.getTime());


            List<Food> foods = foodRepo.findByExpirationDateBetweenOrderByExpirationDate(
                    new SimpleDateFormat("yyyy-MM-dd").parse(endDay),
                    new SimpleDateFormat("yyyy-MM-dd").parse(startDay)
            );

            List<GetFoodDto> collect = foods.stream()
                    .map(m-> new GetFoodDto(m.getFoodId(), m.getCategoryId(), m.getName(), m.getExpirationDate(), m.getImageUrl(), m.getCreated_at()))
                    .collect(Collectors.toList());

            return collect;

        }catch (Exception e){

        }
        return null;
    }

    public GetFoodDto getFoodById (Integer id) {
        try {
            Food food = foodRepo.findById(id).orElseThrow();
            GetFoodDto foodDto = GetFoodDto.builder()
                    .foodId(food.getFoodId())
                    .categoryId(food.getCategoryId())
                    .name(food.getName())
                    .expiration_date(food.getExpirationDate())
                    .image_url(food.getImageUrl())
                    .created_at(food.getCreated_at())
                    .build();
            return foodDto;
        } catch (Exception e) {
        }
        return null;
    }

    public GetFoodDto addFood (PostFoodDto dto){

        FoodCategory category = foodCategoryRepo.findById(1).orElseThrow();

        Food food = Food.builder()
                .CategoryId(category)
                .name("어플리케이션 서버 생성 이름")
                .expirationDate(new Date())
                .imageUrl(dto.getImage_url())
                .created_at(new Date())
                .build();

        foodRepo.save(food);

        Food result = foodRepo.findByImageUrl(dto.getImage_url()).orElseThrow();

        GetFoodDto resultDto = GetFoodDto.builder()
                .foodId(result.getFoodId())
                .categoryId(result.getCategoryId())
                .name(result.getName())
                .expiration_date(result.getExpirationDate())
                .image_url(result.getImageUrl())
                .created_at(result.getCreated_at())
                .build();

        return resultDto;
    }

    public GetFoodDto addFoodByManual(PostFoodManualDto dto) {
        FoodCategory category = foodCategoryRepo.findById(dto.getFood_category_id()).orElseThrow();

        Food food = Food.builder()
                .CategoryId(category)
                .name(dto.getName())
                .expirationDate(dto.getExpiration_date())
                .imageUrl(dto.getImage_url())
                .created_at(dto.getCreated_at())
                .build();

        foodRepo.save(food);

        Food result = foodRepo.findByImageUrl(dto.getImage_url()).orElseThrow();

        GetFoodDto resultDto = GetFoodDto.builder()
                .categoryId(result.getCategoryId())
                .foodId(result.getFoodId())
                .name(result.getName())
                .expiration_date(result.getExpirationDate())
                .image_url(result.getImageUrl())
                .created_at(result.getCreated_at())
                .build();

        return resultDto;
    }

    public String deleteFood(Integer id){
        foodRepo.deleteFoodByFoodId(id);
        return "성공입니다.";
    }
}