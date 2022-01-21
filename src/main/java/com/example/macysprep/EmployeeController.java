package com.example.macysprep;

import com.example.macysprep.exceptions.EmployeeNotFoundException;
import com.example.macysprep.pojos.Employee;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(value = "/employee")
    public ResponseEntity<Employee> getEmployee(@RequestParam(name = "type") String type) {

        HttpHeaders httpHeaders = new HttpHeaders();
        if (type.equals("xml")) {
            httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_XML_VALUE));
        } else {
            httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        }

        Employee employee = new Employee("e1", 10000);

        return new ResponseEntity<Employee>(employee, httpHeaders, HttpStatus.OK);
    }


    // 2nd version
    @GetMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Employee getEmployee() {

        Employee employee = new Employee("e1", 10000);

        return employee;
    }


    @GetMapping("/employee/ex")
    public ResponseEntity throwEmployeeException() {
        try {
            throw new EmployeeNotFoundException("Employee not found, chal nikal!");
        } catch (EmployeeNotFoundException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/ex/v2")
    public ResponseEntity throwEmployeeExceptionControllerAdvice() {
        throw new EmployeeNotFoundException("Employee not found, chal nikal!");
    }
}
