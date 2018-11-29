package com.chinaedu.controller;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinaedu.entity.Goods;
import com.chinaedu.serviceIpl.IGoodService;
@Controller
@RequestMapping
public class GoodsController {
	@Autowired
	private IGoodService  goodsServce;
	public IGoodService getGoodsServce() {
		return goodsServce;
	}

	public void setGoodsServce(IGoodService goodsServce) {
		this.goodsServce = goodsServce;
	}

	@RequestMapping("/queryAllGoods")
	public ModelAndView queryAll(){
		List <Goods>list=goodsServce.queryAllGoods();
		 // 实例化一个View的ModelAndView实例
		ModelAndView m=new ModelAndView();
		 // 添加一个带名称的model对象
		m.setViewName("/main.jsp");
		m.addObject("list", list);
		return m;
	}
	@RequestMapping("/updateGoods")
	public void updateGoods(Goods g,PrintWriter out){
		int row=goodsServce.upadteGoods(g);
		out.print(row);
		out.flush();
		out.close();
	}
	@RequestMapping("/queryGoodsByPage")
	@ResponseBody
	public  Map<String,Object>queryGoodsByPage(int page,int  count){
		Map<String,Object> map=goodsServce.queryGoodsByPage(page,count);
		//System.out.println(map);
		return map;
		}
	
	@RequestMapping("/getUrl.form")
	@ResponseBody
	public String getUrl(HttpServletRequest request,HttpServletResponse response, Model model) throws IOException{
		String fileName = ServletUtilities.saveChartAsJPEG(createChart(), 700, 400, null, request.getSession());
	    String chartURL=request.getContextPath() + "/chart?filename="+fileName;
		//model.addAttribute("chartURL", chartURL);
		return chartURL;
	}
	  /** 
     * 创建数据集合 
     * @return dataSet 
     */  
    public  CategoryDataset createDataSet() {  
        // 实例化DefaultCategoryDataset对象  
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();  
        List <Goods>list=goodsServce.queryAllGoods();
        for (Goods goods : list) {
        	 dataSet.addValue(goods.getSellprice(), goods.getColor(), goods.getName());  
		}
       
        return dataSet;  
    }  
    /** 
     * 创建JFreeChart对象 
     */  
    public  JFreeChart createChart() {  
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN"); //创建主题样式  
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20)); //设置标题字体  
        standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15)); //设置图例的字体  
        standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 15)); //设置轴向的字体  
        ChartFactory.setChartTheme(standardChartTheme);//设置主题样式  
        // 通过ChartFactory创建JFreeChart  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                "商品信息统计", //图表标题  
                "商品名称", //横轴标题  
                "商品价格",//纵轴标题  
                createDataSet(),//数据集合  
                PlotOrientation.VERTICAL, //图表方向  
                true,//是否显示图例标识  
                false,//是否显示tooltips  
                false);//是否支持超链接  
        chart.getTitle().setFont(new Font("隶书", Font.BOLD, 25)); // 设置标题字体  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); // 设置图例类别字体  
        chart.setBorderVisible(true); // 设置显示边框  
        TextTitle subTitle = new TextTitle("商品信息统计");//实例化TextTitle对象  
        subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM); //设置居中显示  
        chart.addSubtitle(subTitle);//添加子标题  
        CategoryPlot plot = chart.getCategoryPlot(); // 获取绘图区对象  
        plot.setForegroundAlpha(0.8F);//设置绘图区前景色透明度  
        plot.setBackgroundAlpha(0.5F);//设置绘图区背景色透明度  
        plot.setBackgroundPaint(ChartColor.lightGray);//图形背景颜色
       // plot.setBackgroundImage(image);//设置绘图区背景图片  
        CategoryAxis categoryAxis = plot.getDomainAxis();//获取坐标轴对象  
        categoryAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));//设置坐标轴标题字体  
        categoryAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 12));//设置坐标轴尺值字体  
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);// 设置坐标轴标题旋转角度  
        ValueAxis valueAxis = plot.getRangeAxis();// 设置数据轴对象  
        valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
        BarRenderer3D renderer = new BarRenderer3D();  
        renderer.setItemMargin(0.32); // 设置柱间的间距  
        plot.setRenderer(renderer);// 设置图片渲染对象    
        return chart;  
    }
}
