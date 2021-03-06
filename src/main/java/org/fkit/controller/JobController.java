package org.fkit.controller;

import java.util.List;

import org.fkit.domain.Job;
import org.fkit.service.HrmService;
import org.fkit.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理用户请求控制器
 * */
@Controller
public class JobController {
	
	/**
	 * 自动注入jobService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
		
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param employee 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/job/selectJob")
	 public String selectjob(Integer pageIndex,
			 @ModelAttribute Job job,
			 Model model){
		System.out.println("job = " + job);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Job> jobs = hrmService.findJob(job, pageModel);
		model.addAttribute("jobs", jobs);
		model.addAttribute("pageModel", pageModel);
		return "job/job";
		
	}
	
	/**
	 * 处理删除用户请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/job/removejob")
	 public ModelAndView removejob(String ids,ModelAndView mv){
	  //分解id字符串
	  String[] idArray = ids.split(",");
	  for(String id : idArray){
		  hrmService.removeJobById(Integer.parseInt(id));
	  }
	  mv.setViewName("redirect:/job/selectJob");
	  return mv;
	  }
	
	
	/**
	 * 处理修改用户请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param job job  要修改用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/job/updateJob")
	 public ModelAndView updatejob(
			 String flag,
			 @ModelAttribute Job job,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询用户
			Job target = hrmService.findJobById(job.getId());
			// 设置Model数据
			mv.addObject("job", target);
			// 返回修改员工页面
			mv.setViewName("job/showUpdateJob");
		}else{
			// 执行修改操作
			hrmService.modifyJob(job);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/job/selectJob");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param job job  要添加用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/job/addJob")
	 public ModelAndView addjob(
			 String flag,
			 @ModelAttribute Job job,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("job/showAddJob");
		}else{
			// 执行添加操作
			hrmService.addJob(job);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/job/selectJob");
		}
		// 返回
		return mv;
	}
	
}
