package com.itbull.springmvc.handler;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itbull.springmvc.entity.Person;


@RequestMapping(value="/person")
@Controller
@Scope(value="prototype")//非单例  每次都会重新创建
public class PersonHandler {
	//编写一个prepare方法[即加入一个@ModelAttribute注解]，给修改准备model
	//这里之所以会在 目标方法前调用是因为你在该方法前加入了 @ModelAttribute注解
	@ModelAttribute
	public void prepareModel(@RequestParam(value="id",required=false) Integer id 
			,Map<String,Object> map  ){
		//获取到要修改的person的id
		if(id != null){
			//然后通过id到数据库去查找对应的person
			//假定我们从数据库中获取到这个id=100的person
			Person person = new Person();
			person.setId(200);
			person.setName("hsp");
			person.setAddress("beijing");
			//把这个person放入到map中，注意名字，一定要和目标方法的的javabean的 @ModelAttribute的名字一样
			map.put("person", person);
			System.out.println("prepareModel" + person.hashCode());
			
		}
		
		
		//然后给updatePerson
	}
	
	
	/**
	 * 1.在当目标方法的参数中有一个和页面对应的javabean信息时，
	 * springMVC就会将jsp提交的数据封装到目标方法的javabean(person)中
	 * 2.并将javabean对象放入到request域.
	 * 3.在默认情况下，放入到request域中的javabean对象的属性是该Javabean的类名首字母小写的
	 *   Person person2， 即这里的Person类名的 person
	 * 4.其实，如果你的目标方法有一个javabean对象，那么该java对象前，默认会有 @ModelAttribute(value="person")
	 *   即 public String updatePerson(Person person2) 等价
	 *   public String updatePerson(@ModelAttribute(value="person") Person person2)
	 *   
	 * 5.如果我们改变默认放在request域中的javabean的属性名，则可以直接修改
	 *   @ModelAttribute(value="person") 的值 @ModelAttribute(value="myperson")
	 *   
	 */
	//这里我们指定请求方式put
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public String updatePerson(Person person2){
		//如果没有任何的处理，我们就直接去更新person2, 可能造成原来没有修改的数据被清空.
		//解决方法，就在在prepare方法前准备一个model(person) 给updatePerson
		//这里 id = 100 name = 你提交的名 address=beijing
		System.out.println("准备修改的person信息" + person2);
		//??
		System.out.println("updatePerson" + person2.hashCode());
		return "updateOk";
	}
	
	
	@RequestMapping(value="/testMyView")
	public String test01(){
		System.out.println("test0被调用");
		return "myView";
	}
	
	//在目标方法中，直接重定向或者转发的案例
	@RequestMapping(value="/testForwardORRedirect")
	public String testForwardORRedirect(){
		System.out.println("testForwardORRedirect");
		//转发
//		return "forward:/WEB-INF/pages/ok.jsp";
		//重定向, 如果是重定向，就不能重定向到 /WEB-INF目录中!!!
		return "redirect:/login.jsp";
	}
}
