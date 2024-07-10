package com.jpapractice.JpawithPostgre.service;

import com.jpapractice.JpawithPostgre.dto.EmployeeDTO;

public interface EmployeeService
{
    EmployeeDTO createEmpoyee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

}
