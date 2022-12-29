package com.springBootTutorial.springBootTutorial.Service;

import com.springBootTutorial.springBootTutorial.Entity.Department;
import com.springBootTutorial.springBootTutorial.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department  department = Department.builder()
                .departmentName("IT")
                .departmentID(1L)
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test //Whatever method created must be annoted as test, to be used as test function.
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName , found.getDepartmentName());
    }

}