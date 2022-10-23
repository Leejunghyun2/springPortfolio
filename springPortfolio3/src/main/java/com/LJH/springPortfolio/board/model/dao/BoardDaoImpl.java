package com.LJH.springPortfolio.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.LJH.springPortfolio.board.model.dto.BoardDTO;


@Repository
public class BoardDaoImpl implements BoardDAO {
	
	@Inject
	SqlSession session;
	
	@Override
	public int getTotalRecord(BoardDTO paramDto) {
		return session.selectOne("board.getTotalRecord", paramDto);
	}

	@Override
	public List<BoardDTO> getSelectAll(BoardDTO paramDto) {
		return session.selectList("board.getSelectAll", paramDto);
	}

	@Override
	public BoardDTO getSelectOne(BoardDTO paramDto) {
		return session.selectOne("board.getSelectOne", paramDto);
	}

	@Override
	public int setInsert(BoardDTO paramDto) {
		// TODO Auto-generated method stub
		return session.insert("board.setInsert",paramDto);
	}

	@Override
	public int setUpdate(BoardDTO paramDto) {
		// TODO Auto-generated method stub
		return session.update("board.setUpdate",paramDto);
	}

	@Override
	public int setDelete(BoardDTO paramDto) {
		// TODO Auto-generated method stub
		return session.delete("board.setDelete",paramDto);
	}

	@Override
	public int getMaxValue(String str) {
		Map<Object,String> map = new HashMap<>();
		map.put("field", str);
		return session.selectOne("board.getMaxValue",map);
	}

	@Override
	public void setUpdateReLevelNo(BoardDTO paramDto) {
		session.update("board.setUpdateReLevelNo",paramDto);
	}
	
	@Override
	public void setUpdateHit(BoardDTO paramDto) {
		session.update("board.setUpdateHit",paramDto);
	}

}
