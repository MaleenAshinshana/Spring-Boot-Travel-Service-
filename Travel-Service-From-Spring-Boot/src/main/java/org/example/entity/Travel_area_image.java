package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Travel_area_image implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String image_id;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    @Lob
    private String area_image;
    @ManyToOne
    @JoinColumn(name = "area_id",referencedColumnName = "area_id")
    private TravelArea travelArea;

    public Travel_area_image(String image_id, String area_image) {
        this.image_id = image_id;
        this.area_image = area_image;
    }
}
