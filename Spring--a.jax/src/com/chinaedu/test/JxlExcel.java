package com.chinaedu.test;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import com.chinaedu.daoIpl.GoodsDaoIpl;
import com.chinaedu.daoIpl.IGoodsDao;
import com.chinaedu.entity.Student;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlExcel {

	@Resource
	private IGoodsDao iGoodsDao = new GoodsDaoIpl();
	
	public void imp(){
		//创建Excel文件
		String[] title= {"姓名","课程名","分数"};
		File file=new File("f:/sheet1.xls");
		try {
			file.createNewFile();
			//创建工作簿
			WritableWorkbook  workbook=Workbook.createWorkbook(file);
			//创建Sheet
			WritableSheet sheet=workbook.createSheet("表格一", 20);
			//第一行设置列名
			Label label=null;
			for (int i = 0; i < title.length; i++) {
				label=new Label(i, 0, title[i]);//第一个参数为列,第二个为行
				sheet.addCell(label);
			}
			
			List<Student> list=iGoodsDao.queryStudent();
			for (int i = 0; i < list.size(); i++) {
				label=new Label(0,i,list.get(i).getName());
				sheet.addCell(label);
				label=new Label(1,i,list.get(i).getCourse());
				sheet.addCell(label);
				label=new Label(2,i,list.get(i).getScore()+"");
				sheet.addCell(label);
			}
		
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
	new JxlExcel().imp();
}
}


