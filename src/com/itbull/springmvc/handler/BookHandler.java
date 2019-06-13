package com.itbull.springmvc.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(value="/user")
@Controller
public class BookHandler {

	//查询[GET]
	@RequestMapping(value="/book/{id}",method=RequestMethod.GET)
	public String getBook(){
		System.out.println("查询书籍");
		return "bookOk";
	}
	
	//添加[POST]
	@RequestMapping(value="/book",method=RequestMethod.POST)
	public String addBook(){
		System.out.println("添加书籍");
		return "bookOk";
	}
	
	//删除[DELETE]
	@RequestMapping(value="/book/{id}",method=RequestMethod.DELETE)
	public String delBook(){
		System.out.println("删除书籍");
		return "bookOk";
	}
	
	//删除[PUT]
	@RequestMapping(value="/book",method=RequestMethod.PUT)
	public String updateBook(){
		System.out.println("修改书籍");
		return "bookOk";
	}
	
}
