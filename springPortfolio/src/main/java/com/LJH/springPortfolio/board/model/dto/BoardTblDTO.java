package com.LJH.springPortfolio.board.model.dto;

import java.sql.Date;

import com.LJH.springPortfolio._common.Util;

public class BoardTblDTO {
	private String no_;
	private int no;
	private String tbl;
	private String tblName;
	private Date regiDate;
	public String getNo_() {
		return no_;
	}
	public void setNo_(String no_) {
		Util util = new Util();
		this.no = util.getNumberCheck(no_, 0);
		this.no_ = util.getNumberCheck(no_, 0) + "";
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTbl() {
		return tbl;
	}
	public void setTbl(String tbl) {
		this.tbl = tbl;
	}
	public String getTblName() {
		return tblName;
	}
	public void setTblName(String tblName) {
		this.tblName = tblName;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
}
