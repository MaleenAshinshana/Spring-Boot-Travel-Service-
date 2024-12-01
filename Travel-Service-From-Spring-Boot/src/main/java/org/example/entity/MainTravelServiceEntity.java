package org.example.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data

public class MainTravelServiceEntity implements SuperEntity {
    @Id

    private String service_id;

    @NotNull
    private LocalDate start_date;
    @NotNull
    private LocalDate end_date;

    private String no_of_adult;

    private String no_of_child;
    @NotNull
    private String need_a_guide_or_no;

    private String total_hed_count;
    @NotNull
    private LocalDate user_package_start_date;

    /*@NotNull
    private boolean isWithGuide;*/

    private double package_total;

     @NotNull
    private String vehicle_id;

    private String guide_id;

    private String user;

    private String hotel_id;

    private String area;

    private String travelPackage;

}
