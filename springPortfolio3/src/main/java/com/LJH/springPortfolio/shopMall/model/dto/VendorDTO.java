package com.LJH.springPortfolio.shopMall.model.dto;

import java.sql.Date;

import com.LJH.springPortfolio._common.Util;

public class VendorDTO {
	private String vendorCode_;
	private int vendorCode;
	private String vendorName;
	private Date regiDate;
	public String getVendorCode_() {
		return vendorCode_;
	}
	public void setVendorCode_(String vendorCode_) {
		Util util = new Util();
		this.vendorCode_ = util.getNumberCheck(vendorCode_, 0) + "";
		this.vendorCode = util.getNumberCheck(vendorCode_, 0);
	}
	public int getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(int vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
}
