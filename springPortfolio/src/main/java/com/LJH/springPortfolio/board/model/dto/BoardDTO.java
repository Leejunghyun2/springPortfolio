package com.LJH.springPortfolio.board.model.dto;

import java.sql.Date;

import com.LJH.springPortfolio._common.Util;

public class BoardDTO {
	private String no_;
	private String searchQuery;
	private String pageNumber_;
	
	private String tblName;
	
	private int no;
	private int num;
	private String tbl;
	private String writer;
	private String subject ;
	private String content;
	private String email;
	private String passwd;
	private int refNo; 
	private int stepNo;
	private int levelNo;
	private int parentNo;
	private int hit;
	private String ip;
	private int memberNo;
	private int noticeNo;
	private String secretGubun;
	private Date regiDate;
	private String attachInfo;
	private String noticeGubun;
	
	
	
	private String searchGubun;
	private String searchData;
	
	private int preNo;
	private int nxtNo;
	private String preSubject;
	private String nxtSubject;
	
	private int startRecord;
	private int lastRecord;
	public String getTblName() {
		return tblName;
	}
	public void setTblName(String tblName) {
		this.tblName = tblName;
	}
	public String getNoticeGubun() {
		return noticeGubun;
	}
	public void setNoticeGubun(String noticeGubun) {
		this.noticeGubun = noticeGubun;
	}
	public String getNxtSubject() {
		return nxtSubject;
	}
	public void setNxtSubject(String nxtSubject) {
		this.nxtSubject = nxtSubject;
	}

	
	public int getPreNo() {
		return preNo;
	}
	public void setPreNo(int preNo) {
		this.preNo = preNo;
	}
	public int getNxtNo() {
		return nxtNo;
	}
	public void setNxtNo(int nxtNo) {
		this.nxtNo = nxtNo;
	}
	public String getPreSubject() {
		return preSubject;
	}
	public void setPreSubject(String preSubject) {
		this.preSubject = preSubject;
	}
	public int getStartRecord() {
		return startRecord;
	}
	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}
	public int getLastRecord() {
		return lastRecord;
	}
	public void setLastRecord(int lastRecord) {
		this.lastRecord = lastRecord;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTbl() {
		if(tbl == null) {
			tbl = "";
		}
		return tbl;
	}
	public void setTbl(String tbl) {
		this.tbl = tbl;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getRefNo() {
		return refNo;
	}
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	public int getStepNo() {
		return stepNo;
	}
	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}
	public int getLevelNo() {
		return levelNo;
	}
	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getSecretGubun() {
		return secretGubun;
	}
	public void setSecretGubun(String secretGubun) {
		this.secretGubun = secretGubun;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	public String getAttachInfo() {
		return attachInfo;
	}
	public void setAttachInfo(String attachInfo) {
		this.attachInfo = attachInfo;
	}
	public String getSearchGubun() {
		if(searchGubun == null) {
			searchGubun = "";
		}
		return searchGubun;
	}
	public void setSearchGubun(String searchGubun) {
		
		this.searchGubun = searchGubun;
	}
	public String getSearchData() {
		if(searchData == null) {
			searchData = "";
		}
		return searchData;
	}
	public void setSearchData(String searchData) {
		
		this.searchData = searchData;
	}
	public String getNo_() {
		return no_;
	}
	public void setNo_(String no_) {
		Util util = new Util();
		this.no = util.getNumberCheck(no_, 0);
		this.no_ = util.getNumberCheck(no_, 0) + "";
	}
	
	public String getPageNumber_() {
		if(pageNumber_ == null) {
			pageNumber_ = "1";
		}
		return pageNumber_;
	}
	public void setPageNumber_(String pageNumber_) {
		this.pageNumber_ = pageNumber_;
	}
	
	public String getSearchQuery() {
		String imsiSearchYN = "O";
		if(getSearchGubun().equals("")||getSearchData().equals("")) {
			imsiSearchYN = "X";
			searchData ="";
			searchGubun ="";
		}
		
		searchQuery = "searchGubun=&searchData=";
		if(imsiSearchYN.equals("O")) {
			searchQuery = "searchGubun="+searchGubun + "&searchData=" + searchData;
		}
		return searchQuery;
	}
	public void setSearchQuery(String searchQuery) {
		if(searchQuery == null) {
			searchQuery = "&seachGubun=&searchData=";
		}
		this.searchQuery = searchQuery;
	}
}
