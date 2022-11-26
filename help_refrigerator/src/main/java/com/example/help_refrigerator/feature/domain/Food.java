package com.example.help_refrigerator.feature.domain;

import lombok.*;

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

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
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

}
