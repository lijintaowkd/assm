package org.fkit.dao;

import java.util.List;
import java.util.Map;

import org.fkit.domain.Employee;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeDao {
  
  List<Employee> selectByPage(Map<String,Object> params);
  
  Integer count(Map<String,Object> params);
   
  List<Employee> selectAllEmployees(Map<String,Object> params);
  
  Employee selectById(int id);
  
  void deleteById(Integer id);
  
  void save(Employee employee);
  
  void update(Employee employee);
  
}
