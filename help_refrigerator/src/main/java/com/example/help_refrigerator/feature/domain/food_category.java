package com.example.help_refrigerator.feature.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_memo")
@Entity

public class food_category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @Column(length = 1000, nullable = false)
    private String food_category_id;

    @Column(length = 1000, nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String expiration_date;

    @Column(length = 1000, nullable = false)
    private String image_url;

    @Column(length = 1000, nullable = false)
    private String created_at;


}
