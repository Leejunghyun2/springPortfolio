package com.LJH.springPortfolio.shopMall.model.dto;

import java.sql.Date;

import com.LJH.springPortfolio._common.Util;

public class CartDTO {
	Util util = new Util();	
	private int cartNo;
	private String cartNo_;
	
	private int memberNo;
	private String memberNo_;
	
	private int productCode;
	private String productCode_;
	
	private String productName;
	
	private int amount;
	private Date regiDate;
	
	private String productInfo;
	
	private int sumPrice;
	private String attachInfo;

	private String vendorName;
	private int buyMoney;
	
	public int getBuyMoney() {
		return buyMoney;
	}
	public void setBuyMoney(int buyMoney) {
		this.buyMoney = buyMoney;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAttachInfo() {
		return attachInfo;
	}
	
	public void setAttachInfo(String attachInfo) {
		this.attachInfo = attachInfo;
	}
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getCartNo_() {
		return cartNo_;
	}

	public void setCartNo_(String cartNo_) {
		this.cartNo_ = util.getNumberCheck(cartNo_, 0) + "";
		this.cartNo = util.getNumberCheck(cartNo_, 0);
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNo_() {
		return memberNo_;
	}

	public void setMemberNo_(String memberNo_) {
		this.memberNo_ = util.getNumberCheck(memberNo_, 0) + "";
		this.memberNo = util.getNumberCheck(memberNo_, 0);
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductCode_() {
		return productCode_;
	}

	public void setProductCode_(String productCode_) {
		this.productCode_ = util.getNumberCheck(productCode_, 0) + "";
		this.productCode = util.getNumberCheck(productCode_, 0);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = util.getNumberCheck(amount + "", 0);
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
}
