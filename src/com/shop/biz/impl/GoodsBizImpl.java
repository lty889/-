package com.shop.biz.impl;

import java.util.List;
import java.util.Map;

import com.shop.bean.Goods;
import com.shop.bean.Type;
import com.shop.biz.GoodsBiz;
import com.shop.dao.DBHelper;

public class GoodsBizImpl implements GoodsBiz{
	private DBHelper db = new DBHelper();
	
	public List<Map<String, String>> getGoods(String ttname) {
		//System.out.println(ttname);
		String sql = "select * from goodsinfo g join ttypeinfo t on g.ttno=t.ttno where ttname=?";
		return db.finds(sql, ttname);
	}

	@Override
	public Goods getsingleGood(String gname) {
		String sql = "select * from goodsinfo where gname=?";
		List<Goods> goods = db.find(sql, Goods.class, gname);
		if(goods.size()>0){
			return goods.get(0);
		}
		return null;
	}

	@Override
	public List<Goods> getAllGoods() {
		String sql = "select * from goodsinfo";
		return db.find(sql, Goods.class);
	}

	@Override
	public List<Goods> getSexGoods(String tname) {
		String sql = "select * from typeinfo t,ttypeinfo tt,goodsinfo g where g.ttno=tt.ttno and tt.tno=t.tno and tname=?";
		return db.find(sql, Goods.class, tname);
	}

	@Override
	public List<Map<String, String>> getGoodsByPage(String ttname,int page,int count) {
	 String	sql = "select * from goodsinfo g,ttypeinfo tt  where g.ttno=tt.ttno and tt.ttname='"+ttname+"' limit "+(page-1)*count+","+count;
		return db.finds(sql);
	}
	
	
	
	
}
