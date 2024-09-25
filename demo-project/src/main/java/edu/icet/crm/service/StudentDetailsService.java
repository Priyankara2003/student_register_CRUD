package edu.icet.crm.service;


import edu.icet.crm.entity.StudentDetailsEntity;
import edu.icet.crm.model.StudentDetails;
import org.springframework.web.multipart.MultipartFile;

public interface StudentDetailsService {
    void saveStudentDetails(MultipartFile file, StudentDetails std);

    Iterable<StudentDetailsEntity> getAllStudent();

    StudentDetailsEntity getStudent(Long id);
}
