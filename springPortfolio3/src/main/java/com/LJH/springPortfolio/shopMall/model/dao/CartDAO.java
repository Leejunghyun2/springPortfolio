package com.LJH.springPortfolio.shopMall.model.dao;

import java.util.List;

import com.LJH.springPortfolio.shopMall.model.dto.CartDTO;

public interface CartDAO {
	public List<CartDTO> getSelectAll();
	public int setInsert(CartDTO paramDto);
	public List<CartDTO> getSelectCartProductGroup();
	public int setDelete(CartDTO paramDto);
}
