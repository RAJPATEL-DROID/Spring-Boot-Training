package com.jpapractice.JpawithPostgre.repository;

import com.jpapractice.JpawithPostgre.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataJPARepository extends JpaRepository<Employee,Long> {

}
