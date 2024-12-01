package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Travel_area_image;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelAreaDTO {
    private String area_id;

    private String area_location;

    private List<TravelAreaImageDTO> areaImages=new ArrayList<>();

    public TravelAreaDTO(String area_id, String area_location) {
        this.area_id = area_id;
        this.area_location = area_location;
    }
}
