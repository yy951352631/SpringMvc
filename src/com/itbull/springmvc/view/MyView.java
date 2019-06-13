package com.itbull.springmvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

//@Component 表示 该视图会被加载到容器,名字myView
@Component(value="myView")
public class MyView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0,
			HttpServletRequest arg1, HttpServletResponse arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入到自己的视图");
		// 这里我们自己来确定到哪个页面去,默认的视图解析机制就无效
		arg1.getRequestDispatcher("/WEB-INF/pages/ok.jsp").forward(arg1, arg2);
		
	}

}
