package com.itbull.springmvc.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.itbull.springmvc.entity.Master;

/*
 * @SessionAttributes(value={"myMaster"})
 * @SessionAttributes : 表示设置一个session的属性
 * value={"myMaster"} 表示session的属性名是 myMaster.
 * 如果你希望设置多个session属性名
 * value={"myMaster","myMaster2"}, 表示有两个属性名 
 * 
 * 作用: 如果你给你的目标方法的Map集合【是目标方法中定义的map参数】中放入
 * map.setAttribute("myMaster",master), 表示在request域中加入的 master对象
 * 同时在sesesion域中，也加入了这个master的对象
 */
@SessionAttributes(value={"myMaster"})
@RequestMapping("/vote")
@Controller
public class VoteHandler {

	//获取到超链接传递的数据
	/**
	 * @RequestParam(value="name", required=false)
	 * 1.@RequestParam : 表示说明一个接受到的参数
	 * 2.value="name" : 接收的参数名是 name
	 * 3.required=false : 表示该参数可以有，也可以没有 ,如果 required=true,表示必须传递该参数.
	 * 默认是required=true
	 */
	@RequestMapping(value="/vote01")
	public String test01
		(@RequestParam(value="name", required=false) String username){
		
		System.out.println("得到的username =" + username);
		//返回到一个结果
		return "voteOk";
	}
	
	@RequestMapping(value="/vote02")
	public String test02
		(@RequestHeader("Accept-Encoding") String ae){
		
		System.out.println("Accept-Encoding =" + ae);
		//返回到一个结果
		return "voteOk";
	}
	
	//获取到添加的主人信息 
	@RequestMapping(value="/vote03")
	public String test03(Master master,
			HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("主人信息 =" + master);
		System.out.println("masterName =" + request.getParameter("masterName"));
		//返回到一个结果
		return "voteOk";
	}
	
	//获取到添加的主人信息 
	@RequestMapping(value="/vote04")
	public String test04(Master master,
			HttpServletRequest request,HttpServletResponse response){
		
		//说明：springmvc会自动把获取的model模型，放入到request域中，名字就是master
		//将master放入到request
		request.setAttribute("master", master);
		request.setAttribute("address", "北京");
	
		//返回到一个结果
		return "voteOk";
	}
	
	
	//获取到添加的主人信息，并加入到Map<String,Object> 中
	//如果我们在目标方法中，定义了一个  Map<String,Object>参数 ，那么这个map就类似于 
	// struts2中，通过RequestAware 接口得到requestMap集合
	@RequestMapping(value="/vote05")
	public String test05(Map<String,Object> map, Master master){
		
		
		map.put("master", master);
		map.put("address", "beijing");
		//返回到一个结果
		return "voteOk";
	}
	
	//将model放入到ModelAndView对象中，实现将数据放入到request域中
	@RequestMapping(value="/vote06")
	public ModelAndView test06(Master master){
		
		//创建一个ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		//下面这句话就等价于将  master对象放入到request域中，属性名技术 “master”
		modelAndView.addObject("master", master);
		modelAndView.addObject("address","shanghai");
		modelAndView.setViewName("voteOk");
		//返回到一个结果
		return modelAndView;
	}
	
	
	//将model(master对象) 放入到session域中
	@RequestMapping(value="/vote07")
	public String test07(Map<String,Object> map, Master master,HttpSession session){
		
		map.put("myMaster", master);
		map.put("address", "guangzhou");
		session.setAttribute("myMaster2", master);
		
		return "voteOk";
	}
	
	
	//当我们在某个方法上，增加了@ModelAttribute属性后
	//那么在调用该Handler的任何一个方法时，都会先调用这个方法
	@ModelAttribute
	public void prepareUpdate(){
		System.out.println("prepareUpdate....");
	}
	
	@RequestMapping(value="/vote08")
	public String updateMessage(){
		System.out.println("updateMessage...");
		return "voteOk";
	}
	
	//接收表单或者超链接的提交的参数,在提交的参数名和
	//目标方法的形参名一致情况下，可以了省略 @Requestparamter.
	@RequestMapping(value="/vote09")
	public String vote10(String username, String masterName){
		System.out.println("username =" + username);
		System.out.println("masterName =" + masterName);
		return "voteOk";
	}
	
	@RequestMapping(value="/vote010")
	public String vote11(Master master){
		System.out.println("pet =" + master.getPet());
		System.out.println("masterName =" + master.getMasterName());
		return "voteOk";
	}
	
}
