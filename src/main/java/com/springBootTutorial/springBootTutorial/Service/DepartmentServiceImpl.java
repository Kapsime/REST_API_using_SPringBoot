package com.springBootTutorial.springBootTutorial.Service;

import com.springBootTutorial.springBootTutorial.Entity.Department;
import com.springBootTutorial.springBootTutorial.Repository.DepartmentRepository;
import com.springBootTutorial.springBootTutorial.error.DepartmentNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFound {
        Optional<Department> department =  departmentRepository.findById(departmentID);

        if(!department.isPresent()){
            throw new DepartmentNotFound("Department Not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentByID(Long departmentID) {
        departmentRepository.deleteById( departmentID );
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {
        // First we get the dept via deptID , then check if input contains null or empty string & then set.
        Department depDB = departmentRepository.findById(departmentID).get();

        if( Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()) ){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if( Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()) ){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if( Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()) ){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);

    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase( departmentName );
    }


}
