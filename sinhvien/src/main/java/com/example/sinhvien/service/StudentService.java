package com.example.sinhvien.service;

import com.example.sinhvien.entity.Student;
import com.example.sinhvien.dto.StudentCreationRequest;
import com.example.sinhvien.dto.StudentUpdateRequest;
import com.example.sinhvien.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentCreationRequest request){
        Student student = new Student();

        student.setMaSv(request.getMaSv());
        student.setHoTen(request.getHoTen());
        student.setLop(request.getLop());
        student.setSoDienThoai(request.getSoDienThoai());
        student.setDiaChi(request.getDiaChi());
        student.setNgaySinh(request.getNgaySinh());
       

        return studentRepository.save(student);
    }

    public Student updateStudent(String maSv, StudentUpdateRequest request) {
        Student student = getStudent(maSv);

        student.setHoTen(request.getHoTen());
        student.setLop(request.getLop());
        student.setSoDienThoai(request.getSoDienThoai());
        student.setDiaChi(request.getDiaChi());
        student.setNgaySinh(request.getNgaySinh());

        return studentRepository.save(student);
    }

    public void deleteStudent(String id){
        studentRepository.deleteById(id);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(String id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
