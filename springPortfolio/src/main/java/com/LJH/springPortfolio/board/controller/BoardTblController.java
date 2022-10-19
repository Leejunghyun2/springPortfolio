package com.LJH.springPortfolio.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LJH.springPortfolio.board.model.dao.BoardTblDAO;
import com.LJH.springPortfolio.board.model.dto.BoardTblDTO;

@Controller
@RequestMapping("/boardTbl")
public class BoardTblController {

	@Inject
	BoardTblDAO dao;
	String folderName = "boardTbl";
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		String fileName = "list";
		String title = "게시판목록";
		
		List<BoardTblDTO> list = dao.getSelectAll();
		
		model.addAttribute("list",list);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		return "main/main";
	}
	
	@RequestMapping("/chuga")
	public String chuga(Model model) {
		String fileName = "chuga";
		String title = "게시판추가";
		
		
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		return "main/main";
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, BoardTblDTO dto) {
		
		
		int result = dao.setInsert(dto);
		if(result > 0) {
			System.out.println("추가성공");
			return "redirect:/boardTbl/list";
		} else {
			System.out.println("추가처리중 오류발생");
			return "redirect:/boardTbl/chuga";
		}
	}
	
	@RequestMapping("/sujung")
	public String sujung(Model model, BoardTblDTO dto) {
		String fileName = "sujung";
		String title = "게시판수정";
		BoardTblDTO resultDto = dao.getSelectOne(dto);
		
		if(resultDto != null) {
			model.addAttribute("dto",resultDto);
		}
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		return "main/main";
	}
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, BoardTblDTO dto) {
		dto.getNo();
		System.out.println(dto.getNo());
		int result = dao.setUpdate(dto);
		System.out.println(dto.getNo_());
		if(result > 0) {
			System.out.println("수정성공");
			return "redirect:/boardTbl/list";			
		} else {
			System.out.println("수정실패");
			return "redirect:/boardTbl/sujung?no_="+dto.getNo();
		}
	}
	
	@RequestMapping("/sakje")
	public String sakje(Model model,BoardTblDTO dto) {
		String fileName = "sakje";
		String title = "게시판삭제";
		BoardTblDTO resultDto = dao.getSelectOne(dto);
		
		if(resultDto != null) {
			model.addAttribute("dto",resultDto);
		}
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		return "main/main";
	}
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, BoardTblDTO dto) {
		
		int result = dao.setDelete(dto);
		
		if(result > 0) {
			System.out.println("삭제성공");
			return "redirect:/boardTbl/list";			
		} else {
			System.out.println("삭제실패");
			return "redirect:/boardTbl/sakje?no_="+dto.getNo();
		}
	}
	
}
