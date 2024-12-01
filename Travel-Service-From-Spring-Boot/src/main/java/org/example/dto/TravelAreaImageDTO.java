package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.TravelArea;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelAreaImageDTO {
    private String image_id;
    private byte[] area_image;
    private String travelArea;

    public TravelAreaImageDTO(String image_id, byte[] area_image) {
        this.image_id = image_id;
        this.area_image = area_image;
    }


}
