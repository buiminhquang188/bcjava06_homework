package org.cybersoft.buoi32.controller.impl;

import org.cybersoft.buoi32.controller.StudentController;
import org.cybersoft.buoi32.models.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController {
    private List<Student> students = new ArrayList<>();

    @Override
    public ResponseEntity<?> createStudentWithRequestParam(String name, Byte age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        students.add(student);
        return ResponseEntity.ok(this.students);
    }

    @Override
    public ResponseEntity<?> createStudentWithPathVariable(String name, Byte age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        students.add(student);
        return ResponseEntity.ok(this.students);
    }

    @Override
    public ResponseEntity<?> createStudentWithRequestBody(Student studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        students.add(student);
        return ResponseEntity.ok(this.students);
    }
}
