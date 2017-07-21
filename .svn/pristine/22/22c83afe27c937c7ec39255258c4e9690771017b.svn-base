package org.fkit.controller;

import java.util.List;

import org.fkit.domain.Dept;
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
public class DeptController {
	
	/**
	 * 自动注入deptService
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
	@RequestMapping(value="/dept/selectDept")
	 public String selectdept(Integer pageIndex,
			 @ModelAttribute Dept dept,
			 Model model){
		System.out.println("dept = " + dept);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Dept> depts = hrmService.findDept(dept, pageModel);
		model.addAttribute("depts", depts);
		model.addAttribute("pageModel", pageModel);
		return "dept/dept";
		
	}
	
	/**
	 * 处理删除用户请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/dept/removeDept")
	 public ModelAndView removedept(String ids,ModelAndView mv){
	  //分解id字符串
	  String[] idArray = ids.split(",");
	  for(String id : idArray){
		  hrmService.removeDeptById(Integer.parseInt(id));
	  }
	  mv.setViewName("redirect:/dept/selectDept");
	  return mv;
	  }
	
	
	/**
	 * 处理修改用户请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param dept dept  要修改用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/dept/updateDept")
	 public ModelAndView updatedept(
			 String flag,
			 @ModelAttribute Dept dept,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询用户
			Dept target = hrmService.findDeptById(dept.getId());
			// 设置Model数据
			mv.addObject("dept", target);
			// 返回修改员工页面
			mv.setViewName("dept/showUpdateDept");
		}else{
			// 执行修改操作
			hrmService.modifyDept(dept);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param dept dept  要添加用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/dept/addDept")
	 public ModelAndView adddept(
			 String flag,
			 @ModelAttribute Dept dept,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("dept/showAddDept");
		}else{
			// 执行添加操作
			hrmService.addDept(dept);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}
	
}
