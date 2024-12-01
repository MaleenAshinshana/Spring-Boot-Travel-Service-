package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelArea implements SuperEntity{
   @Id
   @GeneratedValue (strategy = GenerationType.UUID)
   private String area_id;
   @Column(nullable = false)
   private String area_location;
    @OneToMany(mappedBy = "travelArea")
   private List<Travel_area_image> areaImages;

   public TravelArea(String area_id, String area_location) {
      this.area_id = area_id;
      this.area_location = area_location;
   }
}
