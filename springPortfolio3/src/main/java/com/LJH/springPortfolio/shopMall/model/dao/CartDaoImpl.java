package com.LJH.springPortfolio.shopMall.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.LJH.springPortfolio.shopMall.model.dto.CartDTO;

@Repository
public class CartDaoImpl implements CartDAO {

	@Inject
	SqlSession session;
	
	@Override
	public List<CartDTO> getSelectAll() {
		return session.selectList("cart.getSelectAll");
	}



	@Override
	public int setInsert(CartDTO paramDto) {
		return session.insert("cart.setInsert", paramDto);
	}

	
	@Override
	public int setDelete(CartDTO paramDto) {
		return session.delete("cart.setDelete", paramDto);
	}



	@Override
	public List<CartDTO> getSelectCartProductGroup() {
		
		return session.selectList("cart.getSelectCartProductGroup");
	}



}
