package com.LJH.springPortfolio.shopMall.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.LJH.springPortfolio.shopMall.model.dto.VendorDTO;

@Repository
public class VendoDaoImpl implements VendorDAO {

	@Inject
	SqlSession session;
	
	
	@Override
	public List<VendorDTO> getSelectAll() {
		return session.selectList("vendor.getSelectAll");
	}

	@Override
	public VendorDTO getSelectOne(VendorDTO paramDto) {
		return session.selectOne("vendor.getSelectOne",paramDto);
	}

	@Override
	public int setInsert(VendorDTO paramDto) {
		return session.insert("vendor.setInsert",paramDto);
	}

	@Override
	public int setUpdate(VendorDTO paramDto) {
		return session.update("vendor.setUpdate",paramDto);
	}

	@Override
	public int setDelete(VendorDTO paramDto) {
		return session.delete("vendor.setDelete",paramDto);
	}

}
