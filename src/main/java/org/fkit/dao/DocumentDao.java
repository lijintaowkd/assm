package org.fkit.dao;

import java.util.List;
import java.util.Map;

import org.fkit.domain.Document;
import org.springframework.stereotype.Repository;
@Repository
public interface DocumentDao {
  
  List<Document> selectByPage(Map<String,Object> params);
  
  Integer count(Map<String,Object> params);
   
  Document selectById(int id);
  
  void deleteById(Integer id);
  
  void save(Document document);
  
  void update(Document document);
  
}
