package com.jpapractice.JpawithPostgre.service;

import com.jpapractice.JpawithPostgre.dto.EmployeeDTO;
import com.jpapractice.JpawithPostgre.entity.Employee;
import com.jpapractice.JpawithPostgre.exception.ResourceNotFoundException;
import com.jpapractice.JpawithPostgre.mapper.EmployeeMapper;
import com.jpapractice.JpawithPostgre.repository.EmployeeDataJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDataJPARepository repository;

    @Override
    public EmployeeDTO createEmpoyee(EmployeeDTO employeeDTO) {
        Employee savedEmployee = repository.save(EmployeeMapper.mapToEmployee(employeeDTO));

        return  EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = repository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given id : " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);

    }
}
