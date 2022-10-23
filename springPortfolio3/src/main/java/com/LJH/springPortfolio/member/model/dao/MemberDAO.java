package com.LJH.springPortfolio.member.model.dao;

import java.util.List;

import com.LJH.springPortfolio.member.model.dto.MemberDTO;

public interface MemberDAO {

	
	public int getTotalRecord(MemberDTO paramDto);
	public List<MemberDTO> getSelectAll(MemberDTO paramDto);
	public MemberDTO getSelectOne(MemberDTO paramDto);
	public int setInsert(MemberDTO paramDto);
	public int setUpdate(MemberDTO paramDto);
	public int setDelete(MemberDTO paramDto);
	public MemberDTO getLogin(MemberDTO paramDto);
		
}
