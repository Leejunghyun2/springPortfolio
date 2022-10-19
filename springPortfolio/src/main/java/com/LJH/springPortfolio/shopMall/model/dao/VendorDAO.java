package com.LJH.springPortfolio.shopMall.model.dao;

import java.util.List;

import com.LJH.springPortfolio.shopMall.model.dto.VendorDTO;

public interface VendorDAO {
	public List<VendorDTO> getSelectAll();
	public VendorDTO getSelectOne(VendorDTO paramDto);
	public int setInsert(VendorDTO paramDto);
	public int setUpdate(VendorDTO paramDto);
	public int setDelete(VendorDTO paramDto);
}
