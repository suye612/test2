package com.chinaedu.serviceIpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaedu.daoIpl.IGoodsDao;
import com.chinaedu.entity.Goods;
@Service
public class GoodsServiceIpl implements IGoodService{
	@Autowired
	private IGoodsDao goosdao;

	public List<Goods> queryAllGoods(){
		return goosdao.queryAllGoods();
	}

	@Override
	public int upadteGoods(Goods g) {
		
		return goosdao.updateGoods(g);
	}

	@Override
	public Map<String, Object> queryGoodsByPage(int page, int count) {
		List<Goods>list=goosdao.queryGoodsByPage(page,count);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		System.out.println(list+"......");
		map.put("page", page);
		return map;
	}
	

}
