package com.example.help_refrigerator.feature.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostFoodDto {
    private String image_url;

    @Builder
    public PostFoodDto(String image_url) {
        this.image_url = image_url;
    }
}
