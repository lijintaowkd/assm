package org.fkit.dao;

import java.util.List;
import java.util.Map;

import org.fkit.domain.Job;
import org.fkit.domain.Notice;
import org.springframework.stereotype.Repository;
@Repository
public interface NoticeDao {
  
  List<Notice> selectByPage(Map<String,Object> params);
  
  Integer count(Map<String,Object> params);
   
  List<Notice> selectAllJob();
  
  Notice selectById(int id);
  
  void deleteById(Integer id);
  
  void save(Notice notice);
  
  void update(Notice notice);
  
}
