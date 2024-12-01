package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entity.TravelPackage;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MainTravelServiceDTO {
    private String service_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private String no_of_adult;
    private String no_of_child;
    private String need_a_guide_or_no;
    private String total_hed_count;
    private LocalDate user_package_start_date;

    private double package_total;


   private String user_id;
   private String vehicle_id;
   private String hotel_id;
   private String guide_id;


    private String area;
    private String travelPackage;




    public MainTravelServiceDTO(String service_id, LocalDate start_date, LocalDate end_date, String no_of_adult, String no_of_child, String need_a_guide_or_no, String total_hed_count, LocalDate user_package_start_time, double package_total) {
        this.service_id = service_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.no_of_adult = no_of_adult;
        this.no_of_child = no_of_child;
        this.need_a_guide_or_no = need_a_guide_or_no;
        this.total_hed_count = total_hed_count;
        this.user_package_start_date = user_package_start_time;

        this.package_total = package_total;
    }
}
