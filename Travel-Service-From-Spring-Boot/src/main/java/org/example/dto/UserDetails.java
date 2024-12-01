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
public class UserDetails implements Serializable {
    private String travelId;
    private String user_id;
    @NotBlank
    private String user_name;
    @NotBlank
    private String address;
    @NotBlank
    private String user_registration_time;
    @NotBlank
    private String email;
    @NotBlank
    private String age;
    @NotBlank
    private String password;
    @NotBlank
    private String nic_or_passport_number;

    public UserDetails(String user_id, String user_name, String address, String user_registration_time, String email, String age, String password, String nic_or_passport_number) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.address = address;
        this.user_registration_time = user_registration_time;
        this.email = email;
        this.age = age;
        this.password = password;
        this.nic_or_passport_number = nic_or_passport_number;
    }

}
