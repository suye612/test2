package com.chinaedu.daoIpl;

import java.util.List;
import java.util.Map;

import com.chinaedu.entity.Goods;
import com.chinaedu.entity.Student;

public interface IGoodsDao {
	List<Goods> queryAllGoods();

	int updateGoods(Goods g);
	List<Student> queryStudent();

	List<Goods> queryGoodsByPage(int page, int count);

}
