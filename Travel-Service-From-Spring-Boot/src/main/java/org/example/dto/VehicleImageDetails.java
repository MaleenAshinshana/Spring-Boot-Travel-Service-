package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleImageDetails {
    private String image_id;

    private byte[] vehicle_image;


    private String vehicle_id;
}
