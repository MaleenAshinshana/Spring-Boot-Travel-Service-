package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelImageDetails {
    private String image_id;
    private byte[] hotel_images;
    private String hotel_id;
}
