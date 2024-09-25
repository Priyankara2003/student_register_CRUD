package edu.icet.crm.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_details")
public class StudentDetailsEntity {

    private String firstName;
    private String lastName;
    private String address;
    private String age;
    private String dob;
    @Id
    private Long nic;
    private String email;
    private String phone;
    private String gender;
    @Lob
    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imageData;
}
