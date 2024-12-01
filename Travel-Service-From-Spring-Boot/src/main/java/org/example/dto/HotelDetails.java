package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelDetails implements Serializable {
    private String hotel_id;
    private  String hotel_name;
    private  String hotel_category;
    private  String location;
    private  String email;
    private  String contact_number1;
    private  String contact_number2;
    private  double hotelFee;
    private  String remark;
}
