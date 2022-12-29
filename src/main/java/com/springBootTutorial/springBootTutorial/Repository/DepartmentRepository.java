package com.springBootTutorial.springBootTutorial.Repository;

import com.springBootTutorial.springBootTutorial.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // findbydeptName is not already defined in JPA repos therefore we need to create it unlike other methods.
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
