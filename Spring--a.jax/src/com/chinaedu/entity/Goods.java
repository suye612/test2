package com.chinaedu.entity;

import java.util.Date;


public class Goods {
	private Integer id;
	private String name;
	private Integer count;
	private Date createtime;
	private String description;
	private Double baseprice;
	private Double marketprice;
	private Double sellprice;
	private String sexrequest;
	private Integer commend;
	private Integer clickcount;
	private Integer sellcount;
	private String color;
	private String version;
	private String title;
	private int sellstate;
	
	public int getSellstate() {
		return sellstate;
	}
	public void setSellstate(int sellstate) {
		this.sellstate = sellstate;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getBaseprice() {
		return baseprice;
	}


	public void setBaseprice(Double baseprice) {
		this.baseprice = baseprice;
	}


	public Double getMarketprice() {
		return marketprice;
	}


	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}


	public Double getSellprice() {
		return sellprice;
	}


	public void setSellprice(Double sellprice) {
		this.sellprice = sellprice;
	}


	public String getSexrequest() {
		return sexrequest;
	}


	public void setSexrequest(String sexrequest) {
		this.sexrequest = sexrequest;
	}


	public Integer getCommend() {
		return commend;
	}


	public void setCommend(Integer commend) {
		this.commend = commend;
	}


	public Integer getClickcount() {
		return clickcount;
	}


	public void setClickcount(Integer clickcount) {
		this.clickcount = clickcount;
	}


	public Integer getSellcount() {
		return sellcount;
	}


	public void setSellcount(Integer sellcount) {
		this.sellcount = sellcount;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", count=" + count + ", createtime=" + createtime
				+ ", description=" + description + ", baseprice=" + baseprice + ", marketprice=" + marketprice
				+ ", sellprice=" + sellprice + ", sexrequest=" + sexrequest + ", commend=" + commend + ", clickcount="
				+ clickcount + ", sellcount=" + sellcount + ", color=" + color + ", version=" + version + ", title="
				+ title + ", sellstate=" + sellstate + "]";
	}


	
	
	

	
	

	
	



	

}
