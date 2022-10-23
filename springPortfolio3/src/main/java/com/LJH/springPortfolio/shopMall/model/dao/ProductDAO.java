package com.LJH.springPortfolio.shopMall.model.dao;

import java.util.List;

import com.LJH.springPortfolio.shopMall.model.dto.ProductDTO;


public interface ProductDAO {
	public List<ProductDTO> getSelectAll(ProductDTO paramDto);
	public ProductDTO getSelectOne(ProductDTO paramDto);
	public int setInsert(ProductDTO paramDto);
	public int getTotalRecord(ProductDTO paramDto);
	public int setUpdate(ProductDTO paramDto);
	public int setDelete(ProductDTO paramDto);
}
