package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.StudentDetailsEntity;
import edu.icet.crm.model.StudentDetails;
import edu.icet.crm.repository.StudentDetailsRepository;
import edu.icet.crm.service.StudentDetailsService;
import edu.icet.crm.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentDetailsServiceImpl implements StudentDetailsService {

    final StudentDetailsRepository studentDetailsRepository;
    final ObjectMapper mapper;

    @Override
    public void saveStudentDetails(MultipartFile file, StudentDetails std) {
        try {
            std.setImageData(ImageUtils.compressImage(file.getBytes()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        StudentDetailsEntity studentDetailsEntity = mapper.convertValue(std,StudentDetailsEntity.class);
        studentDetailsRepository.save(studentDetailsEntity);
    }

    @Override
    public Iterable<StudentDetailsEntity> getAllStudent() {
        return studentDetailsRepository.findAll();
    }

    @Override
    public StudentDetailsEntity getStudent(Long id) {
        Optional<StudentDetailsEntity> std = studentDetailsRepository.findById(id);

        StudentDetailsEntity studentDetail = mapper.convertValue(std,StudentDetailsEntity.class);
        studentDetail.setImageData(ImageUtils.decompressImage(studentDetail.getImageData()));

        return studentDetail;
    }
}
