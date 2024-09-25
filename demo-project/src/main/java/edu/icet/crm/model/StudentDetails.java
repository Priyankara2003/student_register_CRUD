package edu.icet.crm.model;

import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class StudentDetails {

    private String firstName;
    private String lastName;
    private String address;
    private String age;
    private String dob;
    private Long nic;
    private String email;
    private String phone;
    private String gender;
    private byte[] imageData;

}
