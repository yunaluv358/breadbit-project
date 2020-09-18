package com.bread.web.bread;
import lombok.*;

import javax.persistence.*;


@Entity @Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "bread")
public class Bread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bread_id") private Long breadId;
    @Column(name = "bread_name", nullable = false) private String breadName;
    @Column(name = "bread_image", nullable = false) private String breadImage;
    @Column(name = "bread_price", nullable = false) private String breadPrice;
    @Column(name = "bread_description", nullable = false) private String breadDescription;
    @Column(name = "bread_image_detail", nullable = false) private String breadImageDetail;
    @Column(name = "option", nullable = false) private String option;
    @Column(name = "allergy", nullable = false) private String allergy;

    @Builder
    public Bread(String breadName,String breadImage,String breadPrice,String breadDescription,String breadImageDetail
    ,String option,String allergy) {
        this.breadName = breadName;
        this.breadImage = breadImage;
        this.breadPrice = breadPrice;
        this.breadDescription = breadDescription;
        this.breadImageDetail = breadImageDetail;
        this.option = option;
        this.allergy = allergy;
    }

}
