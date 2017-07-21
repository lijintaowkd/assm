package org.fkit.dao;

import java.util.List;
import java.util.Map;

import org.fkit.domain.Job;
import org.springframework.stereotype.Repository;
@Repository
public interface JobDao {
  
  List<Job> selectByPage(Map<String,Object> params);
  
  Integer count(Map<String,Object> params);
   
  List<Job> selectAllJob();
  
  Job selectById(int id);
  
  void deleteById(Integer id);
  
  void save(Job job);
  
  void update(Job job);
  
}
