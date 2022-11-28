package com.example.help_refrigerator.feature.domain;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_foods")
@Entity

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CategoryId", referencedColumnName = "categoryId")
    private FoodCategory CategoryId;

    @Column
    private String name;

    @Column
    private Date expirationDate;

    //바코드
    @Column
    private String imageUrl;

    @Column
    private Date created_at;

    public void setAll(Integer food_id, FoodCategory food_category_id, String name, Date expiration, String url, Date created) {
        this.foodId = food_id;
        this.CategoryId = food_category_id;
        this.name = name;
        this.expirationDate = expiration;
        this.imageUrl = url;
        this.created_at = created;
    }

}
