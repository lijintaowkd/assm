package org.fkit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.fkit.domain.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao {
	
   User selectByLoginnameAndPassword(@Param("loginname") String loginname,@Param("password") String password);

   User selectById(Integer id);
   
   void deleteById(Integer id);
   
   void update(User user);
   
   List<User> selectByPage(Map<String,Object> params);
   
   Integer count(Map<String,Object> params);
   
   void save(User user);
}
