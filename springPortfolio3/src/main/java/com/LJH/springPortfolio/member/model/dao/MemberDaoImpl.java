package com.LJH.springPortfolio.member.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.LJH.springPortfolio.member.model.dto.MemberDTO;

@Repository
public class MemberDaoImpl implements MemberDAO {

	@Inject
	SqlSession session;

	@Override
	public int getTotalRecord(MemberDTO paramDto) {
		int result = 0;
		if (session.selectOne("member.getTotalRecord", paramDto) != null) {
			result = session.selectOne("member.getTotalRecord", paramDto);
		}

		return result;
	}

	@Override
	public List<MemberDTO> getSelectAll(MemberDTO paramDto) {
		return session.selectList("member.getSelectAll", paramDto);
	}

	@Override
	public MemberDTO getSelectOne(MemberDTO paramDto) {
		return session.selectOne("member.getSelectOne", paramDto);
	}

	@Override
	public int setInsert(MemberDTO paramDto) {
		return session.insert("member.setInsert", paramDto);
	}

	@Override
	public int setUpdate(MemberDTO paramDto) {
		return session.update("member.setUpdate", paramDto);
	}

	@Override
	public int setDelete(MemberDTO paramDto) {
		return session.delete("member.setDelete", paramDto);
	}

	@Override
	public MemberDTO getLogin(MemberDTO paramDto) {
		return session.selectOne("member.getLogin", paramDto);
	}

}
