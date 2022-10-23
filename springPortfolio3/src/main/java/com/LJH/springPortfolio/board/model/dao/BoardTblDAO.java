package com.LJH.springPortfolio.board.model.dao;

import java.util.List;

import com.LJH.springPortfolio.board.model.dto.BoardTblDTO;

public interface BoardTblDAO {
	
	
	public List<BoardTblDTO> getSelectAll();
	public BoardTblDTO getSelectOne(BoardTblDTO paramDto);
	public int setInsert(BoardTblDTO paramDto);
	public int setUpdate(BoardTblDTO paramDto);
	public int setDelete(BoardTblDTO paramDto);
}
