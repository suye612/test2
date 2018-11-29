<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
	queryGoodsByPage(1,5);
	})
	
 function queryGoodsByPage(page,count){
	   $.ajax({
			url:"queryGoodsByPage.form",
			type:"post",
			data:{
				"page":page,
				"count":count
			},
			//dataType:"json",
		success:function(data){
			 $("#tobody tr").remove();
			 for(var i=0;i<data.list.length;i++){
				 var tr = $("<tr>" +
						"<td>"+data.list[i].id+"</td>" +
						"<td>"+data.list[i].name+"</td>" +
						"<td>"+data.list[i].sellprice+"</td>" +
						"<td><a href='javascript:;' onclick='delGoods(this)'>删除</a>  " +
						"<a href='javascript:;' onclick='editGoods(this)'>编辑</a>" +
						"</td>" +
						"</tr>")
				$("#tbody").append(tr);
			} 
		}
		})  
		
	} 
	  
	
	
	function  editGoods(obj){
		var id = $(obj).parent().parent().children().eq(0).text();
		if($(obj).val() == '编辑'){
			var nameObj = $(obj).parent().parent().children().eq(1);
			nameObj.html("<input value='"+nameObj.text()+"' />");
			var priceObj=$(obj).parent().parent().children().eq(2);
			priceObj.html("<input value='" + priceObj.text() +"'/>");
			$(obj).val("保存 ");
		}else{
			var nameObj=$(obj).parent().parent().children().eq(1);
			var priceObj=$(obj).parent().parent().children().eq(2);
			$(obj).val("编辑 ");
			$.ajax({
				url:"updateGoods.form",
				type:"get",
				data:{
					"id":id,
					"name":nameObj.children().eq(0).val(),
					"sellprice":priceObj.children().eq(0).val()
				},
				sucess:function(data){
					if(data=='1'){
						nameObj.html("<input value='"+nameObj.text()+"'/>");
						priceObj.html("<input value='" + priceObj.text() +"'/>");
					}else{
						alert("修改失败")
					}
				}
				
			})
		}
	}
function showGraphic(){
	$.ajax({
		url:"getUrl.form",
		type:"get",
		success:function(data){
		//alert(data)
		$("#img").attr("src",data);
	}
	})  
}
</script>
</head>
<body>
	&emsp;&emsp;<a href="queryAllGoods.form">显示商品</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<a href="javascript:showGraphic()">柱状图显示</a>
	<table border=1>
	<thead>
	<td>商品编号</td><td>商品名称</td><td>商品价格</td><td>操作</td>
	</thead>
	<tbody id="tbody"></tbody>
	</table>
 	<div id="show">
 	<img id="img" alt="" src="" width="400px" height="400px">
 	</div>
</body>
</html>