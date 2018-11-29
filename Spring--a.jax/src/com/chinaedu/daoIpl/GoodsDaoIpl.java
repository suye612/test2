package com.chinaedu.daoIpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.chinaedu.entity.Goods;
import com.chinaedu.entity.Student;
import com.chinaedu.util.DS;

@Repository("iGoodsDao")
public class GoodsDaoIpl implements  IGoodsDao{
	private  static QueryRunner query = new QueryRunner(DS.getDs(), true);
	public List<Goods> queryAllGoods(){
		String sql="select * from t_goods";
		List<Goods>list=null;
		try {
			list=(List<Goods>)query.query(sql, new BeanListHandler<>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	@Override
	public int updateGoods(Goods g) {
		String  sql="update t_goods set name=?,sellprice=? where id=? ";
		try {
			int row = query.update(sql,g.getName(),g.getSellprice(),g.getId());
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Goods> queryGoodsByPage(int page, int count) {
		String sql="select * from t_goods limit  ?,? ";
		List<Goods>list=null;
		try {
			 list = query.query(sql,new BeanListHandler<>(Goods.class),(page-1)*count,count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Student> queryStudent() {
		String sql="select * from t_student ";
		List<Student>list=null;
		try {
			 list = query.query(sql,new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
