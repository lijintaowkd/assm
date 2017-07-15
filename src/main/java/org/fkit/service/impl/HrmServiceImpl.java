package org.fkit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fkit.dao.UserDao;
import org.fkit.domain.Dept;
import org.fkit.domain.Document;
import org.fkit.domain.Employee;
import org.fkit.domain.Job;
import org.fkit.domain.Notice;
import org.fkit.domain.User;
import org.fkit.service.HrmService;
import org.fkit.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService{

	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password) {
       System.out.println("HrmServiceImpl login -->>");
		return userDao.selectByLoginnameAndPassword(loginname, password);
	}

	@Transactional(readOnly=true)
	@Override
	public User findUserById(Integer id) {

		return userDao.selectById(id);
	}

	@Override
	public List<User> findUser(User user, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("user", user);
        int recordCount = userDao.count(params);
        System.out.println("recordCount -->"+recordCount);
        pageModel.setRecordCount(recordCount);
        if(recordCount>0){
        	params.put("pageModel", pageModel);
        }
        List<User> users = userDao.selectByPage(params);
		return users;
	}

	
	@Override
	public void removeUserById(Integer id) {

		userDao.deleteById(id);
	}

	@Override
	public void modifyUser(User user) {
       userDao.update(user);		
	}

	@Override
	public void addUser(User user) {
      userDao.save(user);		
	}

	@Override
	public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dept> findDept(Dept dept, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllDept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeDeptById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dept findDeptById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyDept(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Job> findAllJob() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> findJob(Job job, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeJobById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJob(Job job) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job findJobById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyJob(Job job) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice findNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeNoticeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyNotice(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Document> findDocument(Document document, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDocument(Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Document findDocumentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeDocumentById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyDocument(Document document) {
		// TODO Auto-generated method stub
		
	}

	
}
