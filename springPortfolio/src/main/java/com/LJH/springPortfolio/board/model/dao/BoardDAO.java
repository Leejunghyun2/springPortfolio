package com.LJH.springPortfolio.board.model.dao;

import java.util.List;

import com.LJH.springPortfolio.board.model.dto.BoardDTO;

public interface BoardDAO {
	
	public int getTotalRecord(BoardDTO paramDto);
	public List<BoardDTO> getSelectAll(BoardDTO paramDto);
	public BoardDTO getSelectOne(BoardDTO paramDto);
	public int setInsert(BoardDTO paramDto);
	public int setUpdate(BoardDTO paramDto);
	public int setDelete(BoardDTO paramDto);
	public int getMaxValue(String str);
	public void setUpdateReLevelNo(BoardDTO paramDto);
}
