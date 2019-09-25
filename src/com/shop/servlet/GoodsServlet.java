package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shop.bean.Goods;
import com.shop.bean.Type;
import com.shop.biz.GoodsBiz;
import com.shop.biz.impl.GoodsBizImpl;
import com.shop.dao.DBHelper;

@WebServlet("/goodsServlet")
public class GoodsServlet extends HttpServlet {
	private GoodsBiz gb = new GoodsBizImpl();
	private DBHelper db = new DBHelper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String op = req.getParameter("op");
		
		if("togoods".equals(op)) {
			togoods(req,resp,out);
		}else if("getgoods".equals(op)) {
			getgoods(req,resp,out);
		}else if("getAllGoods".equals(op)) {
			getAllGoods(req,resp,out);
		}else if("getSexGoods".equals(op)) {
			getSexGoods(req,resp,out);
		}else if("getGoodsByPage".equals(op)) {
			getGoodsByPage(req,resp,out);
		}
		
	}

	
	private void getGoodsByPage(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
		int count = Integer.parseInt(req.getParameter("count"));
		int page = Integer.parseInt(req.getParameter("page"));
		String ttname = req.getParameter("ttname");
		List<Map<String, String>> goods = gb.getGoods(ttname);
		int totalpage;
		if(goods.size()>0) {
			totalpage = goods.size()%count ==0?goods.size()/count:goods.size()/count+1;
			req.getSession().setAttribute("page",page);
			req.getSession().setAttribute("pages", totalpage);
			goods=gb.getGoodsByPage(ttname, totalpage, count);
		}
		
		
	}

	private void getSexGoods(HttpServletRequest req, HttpServletResponse resp,
			PrintWriter out) {
		String tname = req.getParameter("tname");
		String tno = req.getParameter("tno");
		List<Goods> goods = gb.getSexGoods(tname);
		req.getSession().setAttribute("goods", goods);
		req.getSession().setAttribute("tno", tno);
		out.print(1);
		
	}

	private void getAllGoods(HttpServletRequest req, HttpServletResponse resp,
			PrintWriter out) {
		List<Goods> goods = gb.getAllGoods();		
		req.getSession().setAttribute("goods", goods);
		out.print(1);
	}

	private void getgoods(HttpServletRequest req, HttpServletResponse resp,
			PrintWriter out) {
		String gname = req.getParameter("gname");
		Goods goods = gb.getsingleGood(gname);
		req.getSession().setAttribute("singlegood", goods);
		out.print(1);
	}

	private void togoods(HttpServletRequest req, HttpServletResponse resp,
			PrintWriter out) {
		String ttname = req.getParameter("ttname");
		List<Map<String, String>> goods = gb.getGoods(ttname);
		req.getSession().setAttribute("goods", goods);		
		out.print(1);
	}

}
