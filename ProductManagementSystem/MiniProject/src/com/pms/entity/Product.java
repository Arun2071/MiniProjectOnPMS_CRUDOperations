package com.pms.entity;
import java.sql.Date;
public class Product {

	private int pno;
	private String pname;
	private Double  Price;
	private String dom;
	

	public Product() {
		
		
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}
	public String getDom() {
		return dom;
	}
	public void setDom(String dom) {
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "Product [pno=" + pno + ", pname=" + pname + ", Price=" + Price + ", dom=" + dom + "]";
	}
	
	
	
}
