package com.chinaedu.serviceIpl;

import java.util.List;
import java.util.Map;

import com.chinaedu.entity.Goods;

public interface IGoodService {
	List<Goods> queryAllGoods();


	int upadteGoods(Goods g);


	Map<String, Object> queryGoodsByPage(int page, int count);

}
