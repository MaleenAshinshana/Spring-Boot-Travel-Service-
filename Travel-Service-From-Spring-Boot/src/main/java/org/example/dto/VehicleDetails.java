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
public class VehicleDetails implements Serializable {
    private String vehicle_id;
    @NotBlank
    private String driver_name;
    @NotBlank
    private String driver_contact_number;
    @NotBlank
    private String vehicle_brand;
    @NotBlank
    private String vehicle_category;
    @NotBlank
    private String vehicle_type;
    @NotBlank
    private String fuel_type;
    @NotBlank
    private String fuel_usage;
      @NotBlank
    private String hybrid_or_no;
      @NotBlank
    private String seat_capacity;
      @NotBlank
    private String transmission;
      @NotBlank
    private String remark;

      private String vehicle_image;
}
