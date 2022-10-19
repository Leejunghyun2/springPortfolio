package com.LJH.springPortfolio.board.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.LJH.springPortfolio.board.model.dto.BoardTblDTO;


@Repository
public class BoardTblDaoImpl implements BoardTblDAO{

	@Inject
	SqlSession session;
	
	@Override
	public List<BoardTblDTO> getSelectAll() {
		return session.selectList("boardTbl.getSelectAll");
	}

	@Override
	public BoardTblDTO getSelectOne(BoardTblDTO paramDto) {
		return session.selectOne("boardTbl.getSelectOne",paramDto);
	}

	@Override
	public int setInsert(BoardTblDTO paramDto) {
		return session.insert("boardTbl.setInsert",paramDto);
	}

	@Override
	public int setUpdate(BoardTblDTO paramDto) {
		return session.update("boardTbl.setUpdate",paramDto);
	}

	@Override
	public int setDelete(BoardTblDTO paramDto) {
		return session.delete("boardTbl.setDelete",paramDto);
	}

}
