package com.springBootTutorial.springBootTutorial.Service;

import com.springBootTutorial.springBootTutorial.Entity.Department;
import com.springBootTutorial.springBootTutorial.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {
   public  Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFound;

   public void deleteDepartmentByID(Long departmentID);

   public Department updateDepartment(Long departmentID, Department department);

   public default Department fetchDepartmentByName(String departmentName) {
      return null;
   }
}
