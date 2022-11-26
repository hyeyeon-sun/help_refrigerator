package com.example.help_refrigerator.feature.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_food_category")
@Entity

public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column
    private String name;

    @Column
    private Date expirationDate;

    //바나나 같이 실제 이미지
    @Column
    private String imageUrl;


    @Column
    private String titleImage;

}
