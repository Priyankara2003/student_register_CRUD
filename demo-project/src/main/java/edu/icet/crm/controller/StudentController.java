package edu.icet.crm.controller;

import edu.icet.crm.entity.StudentDetailsEntity;
import edu.icet.crm.model.StudentDetails;
import edu.icet.crm.service.StudentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    final StudentDetailsService studentDetailsService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart("student") StudentDetails student) {

        studentDetailsService.saveStudentDetails(file,student);

        return new ResponseEntity<>("File uploaded successfully with student details", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public Object getAllStudents(){
        Iterable<StudentDetailsEntity> allStudent = studentDetailsService.getAllStudent();

        return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }

    @GetMapping("/get-student")
    public Object getStudent(@RequestParam("id") Long id){
        StudentDetailsEntity std = studentDetailsService.getStudent(id);

        return new ResponseEntity<>(std, HttpStatus.OK);
    }
}


