package com.ewp.crm.controllers.rest;

import com.ewp.crm.models.Client;
import com.ewp.crm.models.Student;
import com.ewp.crm.service.interfaces.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/student")
@PreAuthorize("hasAnyAuthority('OWNER')")
public class StudentRestController {

    private static Logger logger = LoggerFactory.getLogger(StudentRestController.class);

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        ResponseEntity result;
        Student student = studentService.get(id);
        if (student != null) {
            result = ResponseEntity.ok(student);
        } else {
            logger.info("Student with id {} not found", id);
            result = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @PostMapping ("/update")
    public HttpStatus updateStudent(@RequestBody Student student) {
        System.out.println(student);
        studentService.update(student);
        return HttpStatus.OK;
    }

    @GetMapping ("/{id}/client")
    public ResponseEntity<Client> getClientByStudentId(@PathVariable("id") Long id) {
        ResponseEntity result;
        Client client = studentService.get(id).getClient();
        if (client != null) {
            result = ResponseEntity.ok(client);
        } else {
            logger.info("Client for student with id {} not found", id);
            result = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @PostMapping ("/{id}/notify/email")
    public HttpStatus updateNotifyEmailFlag(@RequestParam boolean status, @PathVariable("id") Long id) {
        Student current = studentService.get(id);
        current.setNotifyEmail(status);
        studentService.update(current);
        return HttpStatus.OK;
    }

    @PostMapping ("/{id}/notify/sms")
    public HttpStatus updateNotifySMSFlag(@RequestParam boolean status, @PathVariable("id") Long id) {
        Student current = studentService.get(id);
        current.setNotifySMS(status);
        studentService.update(current);
        return HttpStatus.OK;
    }

    @PostMapping ("/{id}/notify/vk")
    public HttpStatus updateNotifyVKFlag(@RequestParam boolean status, @PathVariable("id") Long id) {
        Student current = studentService.get(id);
        current.setNotifyVK(status);
        studentService.update(current);
        return HttpStatus.OK;
    }
}
