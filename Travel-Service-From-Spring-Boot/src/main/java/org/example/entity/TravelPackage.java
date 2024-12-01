package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TravelPackage implements SuperEntity {

    private String package_cetagory;

    private String package_hotel_cetagory;

    private String package_vehicle_cetagory;




}
