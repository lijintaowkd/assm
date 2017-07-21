package org.fkit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fkit.dao.DeptDao;

import org.fkit.dao.DocumentDao;
import org.fkit.dao.EmployeeDao;

import org.fkit.dao.JobDao;
import org.fkit.dao.NoticeDao;
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
	
	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private JobDao jobDao;
	

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private DocumentDao documentDao;
	

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
       Map<String,Object> params = new HashMap<>();
       params.put("dept", dept);
       int recordCount = deptDao.count(params);
       System.out.println("recordCount-->>"+recordCount);
       pageModel.setRecordCount(recordCount);
       if(recordCount>0){
    	   params.put("pageModel", pageModel);
       }
       List<Dept> depts = deptDao.selectByPage(params);
		return depts;
	}

	@Override
	public List<Dept> findAllDept() {
		
		return deptDao.selectAllDept();
	}

	@Override
	public void removeDeptById(Integer id) {
		
		deptDao.deleteById(id);
	}

	@Override
	public void addDept(Dept dept) {
		
		deptDao.save(dept);
	}

	@Override
	public Dept findDeptById(Integer id) {
		
		return deptDao.selectById(id);
	}

	@Override
	public void modifyDept(Dept dept) {
		
		deptDao.update(dept);
	}

	@Override
	public List<Job> findAllJob() {

		return jobDao.selectAllJob();
	}

	@Override
	public List<Job> findJob(Job job, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("job", job);
        int recordCount = jobDao.count(params);
        System.out.println("recordCount-->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if(recordCount>0){
        	params.put("pageModel", pageModel);
        }
        List<Job> jobs = jobDao.selectByPage(params);
		return jobs;
	}

	@Override
	public void removeJobById(Integer id) {
		jobDao.deleteById(id);
	}

	@Override
	public void addJob(Job job) {
	   jobDao.save(job);
	}

	@Override
	public Job findJobById(Integer id) {
		
		return jobDao.selectById(id);
	}

	@Override
	public void modifyJob(Job job) {
	   jobDao.update(job);
	}

	@Override
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		 Map<String,Object> params = new HashMap<>();
	        params.put("notice", notice);
	        int recordCount = noticeDao.count(params);
	        System.out.println("recordCount-->>"+recordCount);
	        pageModel.setRecordCount(recordCount);
	        if(recordCount>0){
	        	params.put("pageModel", pageModel);
	        }
	        List<Notice> notices = noticeDao.selectByPage(params);
			return notices;
	}

	@Override
	public Notice findNoticeById(Integer id) {
		
		return noticeDao.selectById(id);
	}

	@Override
	public void removeNoticeById(Integer id) {
		noticeDao.deleteById(id);
	}

	@Override
	public void addNotice(Notice notice) {
		noticeDao.save(notice);
	}

	@Override
	public void modifyNotice(Notice notice) {
		noticeDao.update(notice);
	}

	/*****************文件接口实现*************************************/

	/**
	 * HrmService接口findDocument方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<Document> findDocument(Document document, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("document", document);
		int recordCount = documentDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Document> documents = documentDao.selectByPage(params);
		 
		return documents;
	}

	/**
	 * HrmService接口addDocument方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void addDocument(Document document) {
		documentDao.save(document);
		
	}
	/**
	 * HrmService接口removeDocumentById方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void removeDocumentById(Integer id) {
		documentDao.deleteById(id);
		
	}
	/**
	 * HrmService接口modifyDocument方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void modifyDocument(Document document) {
		documentDao.update(document);
		
	}
	/**
	 * HrmService接口findDocumentById方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public Document findDocumentById(Integer id) {
		
		return documentDao.selectById(id);
	}

	
}
