package org.fkit.dao;

import java.util.List;
import java.util.Map;

import org.fkit.domain.Dept;
import org.springframework.stereotype.Repository;
@Repository
public interface DeptDao {
  
  List<Dept> selectByPage(Map<String,Object> params);
  
  Integer count(Map<String,Object> params);
   
  List<Dept> selectAllDept();
  
  Dept selectById(int id);
  
  void deleteById(Integer id);
  
  void save(Dept dept);
  
  void update(Dept dept);
  
}
