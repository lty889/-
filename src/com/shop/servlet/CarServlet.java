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
import com.shop.bean.Goods;
import com.shop.biz.CarBiz;
import com.shop.biz.impl.CarBizImpl;

@WebServlet("/carServlet")
public class CarServlet extends HttpServlet {
	private CarBiz cb = new CarBizImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String op = req.getParameter("op");
		
		if("getCar".equals(op)) {
			getCar(req,resp,out);
		}else if("addCar".equals(op)) {
			addCar(req,resp,out);
		}else if("deletecar".equals(op)) {
			deletecar(req,resp,out);
		}
	}

	private void deletecar(HttpServletRequest req, HttpServletResponse resp,
			PrintWriter out) {
		
		int cno = Integer.parseInt(req.getParameter("cno"));
		String uname = req.getParameter("uname");
		int result = cb.deleteCar(cno);
		List<Map<String, String>> list = cb.getCar(uname);
		System.out.println(result);
		System.out.println(list);
		double total = 0;
		for(Map<String,String> map : list){
			int s = Integer.parseInt(map.get("price")) * Integer.parseInt(map.get("num"));
			total+=s;
		}
		req.getSession().setAttribute("car", list);
		req.getSession().setAttribute("carsize", list.size());
		req.getSession().setAttribute("totalprice", total);
		out.print(result);
		
	}

	/**
	 * 添加到购物车
	 * @param req
	 * @param resp
	 * @param out
	 */
	private void addCar(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
		int uid = Integer.parseInt(req.getParameter("uid"));
		int gno = Integer.parseInt(req.getParameter("gno"));
		int count = Integer.parseInt(req.getParameter("count"));
		String uname = req.getParameter("uname");
		
		
		int result = cb.checkCar(count, uid, gno);
		
		if(result > 0){
			List<Map<String, String>> list = cb.getCar(uname);
			double total = 0;
			for(Map<String,String> map : list){
				int s = Integer.parseInt(map.get("price")) * Integer.parseInt(map.get("num"));
				total+=s;
			}
			req.getSession().setAttribute("car", list);
			req.getSession().setAttribute("carsize", list.size());
			req.getSession().setAttribute("totalprice", total);
			out.print(result);
		}else{
			
			int result1 = cb.setCar(uid, gno, count);
			List<Map<String, String>> list = cb.getCar(uname);
			double total = 0;
			for(Map<String,String> map : list){
				int s = Integer.parseInt(map.get("price")) * Integer.parseInt(map.get("num"));
				total+=s;
			}
			req.getSession().setAttribute("car", list);
			req.getSession().setAttribute("carsize", list.size());
			req.getSession().setAttribute("totalprice", total);
			out.print(result1);
		}
		
	}

	
	/**
	 * 查询购物车内的商品
	 * @param req
	 * @param resp
	 * @param out
	 */
	private void getCar(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
		String uname = (String) req.getAttribute("uname");
		List<Map<String, String>> list = cb.getCar(uname);
		req.getSession().setAttribute("car", list);
		out.print(1);
	}

}
