package com.itbull.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//这里配置了一个 @Controller就已经被springMvc框架接管
@RequestMapping(value="/user")
@Controller
public class UserHandler {
	/*
	 * @RequestMapping(value="login") 表示给这个方法一个url的配置 
	 * 也可以不写value=, 即下面的写法 
	 * @RequestMapping("login")
	 * 
	 */
	@RequestMapping(value="/login")
	public String login(){
		System.out.println("登录了");
		return "loginOk";
	}
	
	/**
	 * method=RequestMethod.POST: 表示请求buy目标方法必须是 post
	 * 注意: RequestMethod.POST 四个选项
	 * POST, GET, PUT, DELETE
	 * 
	 * @return
	 */
	@RequestMapping(value="/buy",method=RequestMethod.POST)
	public String buy(){
		System.out.println("购买商品");
		return "loginOk";
	}
	
	/**
	 * params="bookid" 表示请求该目标方法时，必须给一个bookid参数
	 * @return
	 */
	@RequestMapping(value="/test",params="bookid")
	public String search(){
		System.out.println("查询书籍");
		return "loginOk";
	}
	
	/**
	 * value="/message/** 是Ant风格的资源匹配方式 
	 * 这时可以  /user/message/aa, /user/message/aa/bb/cc的可以
	 */
	@RequestMapping(value="/message/**")
	public String test02(){
		System.out.println("发送消息");
		return "loginOk";
	}
	//我们希望目标方法获取到 username 和 userid
	
	@RequestMapping(value="/reg/{username}/{userid}")
	public String test03(@PathVariable("username") String name, 
			@PathVariable("userid") String id){
		System.out.println("接收到参数是" + "username=" + name + "---" + "usreid=" + id);
		return "loginOk";
	}

	
}
