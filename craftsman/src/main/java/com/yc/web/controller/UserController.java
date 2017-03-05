package com.yc.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.naming.event.EventContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.format.number.PercentFormatter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.InternalResourceView;

import com.google.gson.Gson;
import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.biz.impl.UserBizImpl;
import com.yc.model.JsonModel;


@Controller
public class UserController {
		
	private UserBiz userBiz;
	private JsonModel jsonModel;
	private User user;
	
	@Resource(name = "userBizImpl")
	public void setBookBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	
	
	@RequestMapping(value="/login_user.action")
	public String login(HttpServletRequest request) {
		
		jsonModel = new JsonModel();
		System.out.println( userBiz+"21" );
		user = userBiz.login(user);
		if (user == null) {
			jsonModel.setCode(0);
			jsonModel.setMessage("用户名或密码错误");
		} else {
			HttpSession session=request.getSession();
			session.setAttribute("loginuser", user);
			jsonModel.setCode(1);
			jsonModel.setMessage("登陆成功");
		}
		return "jsonBean";
	}
	

	protected void outJson(Object obj, HttpServletResponse response) throws IOException {
		// 以json格式返回给客户端
		Gson gson = new Gson();
		String jsonString = gson.toJson(obj);
		// 以流的方式写出客户端
		// 取流 response.getWriter();
		// 设定回传的数据类型 json contentType
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonString);
		out.flush();
		out.close();
	}

}
