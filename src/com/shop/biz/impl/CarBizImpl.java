package com.shop.biz.impl;

import java.util.List;
import java.util.Map;

import com.shop.bean.Car;
import com.shop.bean.Goods;
import com.shop.biz.CarBiz;
import com.shop.dao.DBHelper;

public class CarBizImpl implements CarBiz {
	private DBHelper db = new DBHelper();

	@Override
	public List<Map<String, String>> getCar(String uname) {
		String sql = "select * from carinfo c,users u,goodsinfo g where c.uid=u.uid and c.gno=g.gno and uname=?";
		
		return db.finds(sql, uname);
	}

	@Override
	public int setCar(int uid, int gno, int num) {
		String sql = "insert into carinfo values(null,?,?,?)";
		
		
		return db.update(sql,uid,gno,num);
	}
	
	
	@Override
	public int checkCar(int count, int uid, int gno) {
		String sql = "update carinfo set num=num+? where uid=? and gno=?";
		return db.update(sql, count,uid,gno);
	}

	@Override
	public int deleteCar(int cno) {
		String sql = "delete from carinfo where cno = ?";
		return db.update(sql, cno);
	}

	
	
}
