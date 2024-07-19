package org.cybersoft.buoi32.controller;

import org.cybersoft.buoi32.models.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/student", produces = "application/json")
public interface StudentController {
    @PostMapping("/request-param")
    ResponseEntity<?> createStudentWithRequestParam(@RequestParam String name, @RequestParam Byte age);

    @PostMapping("/path-variable/{name}/{age}")
    ResponseEntity<?> createStudentWithPathVariable(@PathVariable String name, @PathVariable Byte age);

    @PostMapping("/request-body")
    ResponseEntity<?> createStudentWithRequestBody(@RequestBody Student studentDto);
}
