package com.shop.biz;

import java.util.List;
import java.util.Map;

import com.shop.bean.Goods;
import com.shop.bean.Type;

public interface GoodsBiz {

	/**
	 * 根据分类得到所有的商品
	 * @param ttname
	 * @return
	 */
	public List<Map<String,String>> getGoods(String ttname);
	
	public List<Goods> getAllGoods();
	
	public List<Goods> getSexGoods(String tname);

	/**
	 * 得到单个商品信息
	 * @param ttname
	 * @return
	 */
	public Goods getsingleGood(String gname);

	

	List<Map<String,String>> getGoodsByPage(String ttname, int page, int count);
	
}
