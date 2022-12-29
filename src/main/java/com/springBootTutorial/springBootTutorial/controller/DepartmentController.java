package com.springBootTutorial.springBootTutorial.controller;

import com.springBootTutorial.springBootTutorial.Entity.Department;
import com.springBootTutorial.springBootTutorial.Service.DepartmentService;
import com.springBootTutorial.springBootTutorial.error.DepartmentNotFound;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // to add Logger.
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        //logger adding here only , can be added in other api as well.
        LOGGER.info("Inside saveDepartment");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentID) throws DepartmentNotFound {
        return departmentService.fetchDepartmentByID(departmentID);
    }

    @DeleteMapping( "/departments/{id}" )
    public String deleteDepartmentByID(@PathVariable("id") Long departmentID ){
        departmentService.deleteDepartmentByID( departmentID  );
        return "Department deleted successfully";
    }

    @PutMapping( "/departments/{id}" )
    public Department updateDepartment(@PathVariable("id") Long departmentID ,
                                       @RequestBody Department department){
        return departmentService.updateDepartment( departmentID , department ) ;
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }





}
