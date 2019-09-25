package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.bean.Car;
import com.shop.bean.User;
import com.shop.biz.CarBiz;
import com.shop.biz.UserBiz;
import com.shop.biz.impl.CarBizImpl;
import com.shop.biz.impl.UserBizImpl;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private UserBiz ub = new UserBizImpl();
	private CarBiz cb = new CarBizImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String op = req.getParameter("op");
		
		if("reg".equals(op)) {
			reg(req,resp,out);
		}else if("login".equals(op)) {
			login(req,resp,out);
		}
	}

	
	private void login(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User user =  ub.login(uname, pwd);
		if(user!=null) {
			req.getSession().setAttribute("user", user);
			List<Map<String, String>> list = cb.getCar(uname);
			double total = 0;
			for(Map<String,String> map : list){
				int s = Integer.parseInt(map.get("price")) * Integer.parseInt(map.get("num"));
				total+=s;
			}
			
			
			req.getSession().setAttribute("car", list);
			req.getSession().setAttribute("carsize", list.size());
			req.getSession().setAttribute("totalprice", total);
			out.print(1);
		}else {
			out.print(0);
		}
	}

	
	private void reg(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String rname = req.getParameter("rname");
		String email = req.getParameter("email");
		int result = ub.reg(uname, pwd, rname, email);
		out.print(result);
	}

	
}
