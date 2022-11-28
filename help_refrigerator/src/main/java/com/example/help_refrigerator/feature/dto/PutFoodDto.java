package com.example.help_refrigerator.feature.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PutFoodDto {

    private Integer food_id;

    private Integer food_category_id;

    private String name;

    private Date expiration_date;
    private String image_url;

    private Date created_at;

    @Builder
    public PutFoodDto(Integer food_id, Integer categoryId, String name, Date expiration_date, String image_url, Date created_at) {
        this.food_id = food_id;
        this.food_category_id = categoryId;
        this.name = name;
        this.expiration_date = expiration_date;
        this.image_url = image_url;
        this.created_at = created_at;
    }



}
