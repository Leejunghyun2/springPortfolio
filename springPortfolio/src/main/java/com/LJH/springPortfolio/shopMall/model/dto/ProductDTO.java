package com.LJH.springPortfolio.shopMall.model.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.LJH.springPortfolio._common.Util;

public class ProductDTO {
		private String productCode_;
		private int productCode;
		private String productName;
		
		private String productPrice_;
		private int productPrice;
		
		private int vendorCode;
		private String vendorName;
		
		private String attachInfo;
		private Date regiDate;
		
		private MultipartFile file;
		
		private MultipartFile file_1;
		private MultipartFile file_2;
		private MultipartFile file_0;
		
		
	
		public MultipartFile getFile_1() {
			return file_1;
		}
		public void setFile_1(MultipartFile file_1) {
			System.out.println(file_1);
			this.file_1 = file_1;
		}
		public MultipartFile getFile_2() {
			return file_2;
		}
		public void setFile_2(MultipartFile file_2) {
			this.file_2 = file_2;
		}
		public MultipartFile getFile_0() {
			return file_0;
		}
		public void setFile_0(MultipartFile file_0) {
			this.file_0 = file_0;
		}
		Util util = new Util();
		public MultipartFile getFile() {
			return file;
		}
		public void setFile(MultipartFile file) {
			this.file = file;
		}
		public String getVendorName() {
			return vendorName;
		}
		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}
		public String getProductCode_() {
			return productCode_;
		}
		public void setProductCode_(String productCode_) {
			this.productCode_ = util.getNumberCheck(productCode_, 0) + "";
			this.productCode = util.getNumberCheck(productCode_, 0);
		}
		public int getProductCode() {
			return productCode;
		}
		public void setProductCode(int productCode) {
			this.productCode = productCode;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductPrice_() {
			return productPrice_;
		}
		public void setProductPrice_(String productPrice_) {
			this.productPrice_ = util.getNumberCheck(productPrice_, 0) + "";
			this.productPrice = util.getNumberCheck(productPrice_, 0);
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		public int getVendorCode() {
			return vendorCode;
		}
		public void setVendorCode(int vendorCode) {
			this.vendorCode = vendorCode;
		}
		public String getAttachInfo() {
			return attachInfo;
		}
		public void setAttachInfo(String attachInfo) {
			this.attachInfo = attachInfo;
		}
		public Date getRegiDate() {
			return regiDate;
		}
		public void setRegiDate(Date regiDate) {
			this.regiDate = regiDate;
		}
}
