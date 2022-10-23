package com.LJH.springPortfolio.shopMall.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.LJH.springPortfolio.member.model.dto.MemberDTO;
import com.LJH.springPortfolio.shopMall.model.dto.ProductDTO;

@Repository
public class ProductDaoImpl implements ProductDAO {

	@Inject
	SqlSession session;
	
	@Override
	public List<ProductDTO> getSelectAll(ProductDTO paramDto) {
		
		
		return session.selectList("product.getSelectAll",paramDto);
	}
	
	@Override
	public int getTotalRecord(ProductDTO paramDto) {
		int result = 0;
		if (session.selectOne("product.getTotalRecord", paramDto) != null) {
			result = session.selectOne("product.getTotalRecord", paramDto);
		}

		return result;
	}
	
	@Override
	public ProductDTO getSelectOne(ProductDTO paramDto) {
		return session.selectOne("product.getSelectOne", paramDto);
	}

	@Override
	public int setInsert(ProductDTO paramDto) {
		return session.insert("product.setInsert", paramDto);
	}

	@Override
	public int setUpdate(ProductDTO paramDto) {
		return session.update("product.setUpdate", paramDto);
	}

	@Override
	public int setDelete(ProductDTO paramDto) {
		return session.delete("product.setDelete", paramDto);
	}

}
