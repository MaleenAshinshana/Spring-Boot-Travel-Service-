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
public class GuideDetails implements Serializable {
    private String guide_id;
    private String guide_name;
    private String address;
    private String age;
    private String contact_number;
    private String gender;
    private String experience;
    private double man_day_value;
    private String  remark;
    private String profile_picture;
    private String guide_nic_image;
    private String guide_id_image;

    private String travelId;
}
