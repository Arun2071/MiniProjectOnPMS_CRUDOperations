package com.pms.service;

import java.util.List;

import com.pms.entity.Product;

public interface IProductService {
	
	public int addProd(Product prod);
	public int updateProd(Product prod);
	public int deleteProdByNo(int prodNo);
	public Product getProdByNo(int prodNo);
	public List<Product> getAll();
}
