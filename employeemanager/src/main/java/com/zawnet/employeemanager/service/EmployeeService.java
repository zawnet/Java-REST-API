package com.zawnet.employeemanager.service;

import com.zawnet.employeemanager.exeption.UserNotFoundExeptiond;
import com.zawnet.employeemanager.model.Employee;
import com.zawnet.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
   private final EmployeeRepo employeeRepo;
   @Autowired
   public EmployeeService(EmployeeRepo employeeRepo) {
      this.employeeRepo = employeeRepo;
   }

   public Employee addEmployee(Employee employee){
      employee.setEmmployeeCode(UUID.randomUUID().toString());
      return employeeRepo.save(employee);
   }

   public List<Employee> findAllEmployees(){
      return employeeRepo.findAll();
   }

   public Employee updateEmployee(Employee employee){
      return employeeRepo.save(employee);
   }

   public Employee findEmployeeById(Long id){
      return employeeRepo.findEmployeeById(id)
              .orElseThrow(()->new UserNotFoundExeptiond("User by id "+ id + "was nod found"));
   }
   public void  deleteEmployee(Long id){
      employeeRepo.deleteEmployeeById(id);
   }
}
