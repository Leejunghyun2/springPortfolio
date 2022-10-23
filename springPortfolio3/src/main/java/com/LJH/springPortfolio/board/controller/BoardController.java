package com.LJH.springPortfolio.board.controller;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LJH.springPortfolio._common.Util;
import com.LJH.springPortfolio.board.model.dao.BoardDAO;
import com.LJH.springPortfolio.board.model.dao.BoardTblDAO;
import com.LJH.springPortfolio.board.model.dto.BoardDTO;
import com.LJH.springPortfolio.board.model.dto.BoardTblDTO;
import com.LJH.springPortfolio.member.model.dto.MemberDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	BoardDAO dao;
	@Inject
	BoardTblDAO tblDao;
	
	Util util = new Util();
	String folderName = "board";
	@RequestMapping("/list")
	public String list(Model model, BoardDTO dto) {
		String fileName = "list";
		String title = "게시판목록";
	
		System.out.println(dto.getTbl());
		model.addAttribute("tbl",dto.getTbl());
		int pageNumber = util.getNumberCheck(dto.getPageNumber_(),1);
		int pageSize = 5;
		int blockSize = 5;
		
		

		int totalRecord = dao.getTotalRecord(dto);
		int block = (pageNumber - 1) / blockSize;
		int jj = totalRecord - pageSize * (pageNumber - 1);

		double totalPageDou = Math.ceil(totalRecord / (double) pageSize);
		int totalPage = (int) totalPageDou;

		int startRecord = pageSize * (pageNumber - 1) + 1;
		int lastRecord = pageSize * pageNumber;
		int totalBlock = totalPage / blockSize;
		
		dto.setStartRecord(startRecord);
		dto.setLastRecord(lastRecord);
		
		List<BoardDTO> list = dao.getSelectAll(dto); 
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("blockSize", blockSize);
		model.addAttribute("block", block);
		model.addAttribute("jj", jj);
		
		model.addAttribute("title",title);
		model.addAttribute("list",list);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		model.addAttribute("title",title);
		model.addAttribute("fileName",fileName);
		model.addAttribute("folderName",folderName);
		
		
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/chuga")
	public String chuga(Model model, BoardDTO dto) {
		String fileName = "chuga";
		String title = "게시판등록";
		if(dto.getNo() > 0) {
			title = "답변등록";
			dto = dao.getSelectOne(dto);
		}
		List<BoardTblDTO> BoardTblList = tblDao.getSelectAll();
		
		model.addAttribute("tblList",BoardTblList);
		model.addAttribute("dto", dto);
		model.addAttribute("title",title);
		model.addAttribute("fileName",fileName);
		model.addAttribute("folderName",folderName);
		
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, BoardDTO dto, HttpSession session){
		System.out.println(dto.getTbl());
		dto.setNum(dao.getMaxValue("num") + 1);
		dto.setRefNo(dao.getMaxValue("refNo") + 1);
		dto.setStepNo(1);
		dto.setLevelNo(1);
		if(dto.getNo() > 0) {
			BoardDTO resultDto = dao.getSelectOne(dto);
			dto.setRefNo(resultDto.getRefNo());
			dto.setStepNo(resultDto.getStepNo() + 1);
			
			dao.setUpdateReLevelNo(resultDto);
			 
			dto.setLevelNo(resultDto.getLevelNo() + 1);
			dto.setParentNo(resultDto.getNo());
			dto.setNoticeGubun("F");
		}
		
		dto.setContent(util.getCheckString(dto.getContent()));
		
		try {
			dto.setIp(util.getIp());
		} catch (UnknownHostException e) {
			dto.setIp("-");
		}
		
		
		
		if(session.getAttribute("sessionNo") != null) {
			dto.setMemberNo((int)session.getAttribute("sessionNo"));
		}
		if(dto.getNoticeGubun().equals("T")) {
			dto.setNoticeNo(dao.getMaxValue("noticeNo")+1);
		}
		dto.setAttachInfo("-");
		
		
		int result = dao.setInsert(dto);
		if(result > 0) {
			return "redirect:/board/list?tbl="+dto.getTbl();
		}else {
			return "redirect:/board/chuga?tbl="+dto.getTbl();
		}
		
		
		
	}
	
	@RequestMapping("/view")
	public String view(
			Model model,
			BoardDTO dto
		) {
		String searchGubun = dto.getSearchGubun();
		String searchData = dto.getSearchData();
		String pageNumber = dto.getPageNumber_();
		String title = "게시글상세보기";
		
		String fileName = "view";
		
		dao.setUpdateHit(dto);
		dto = dao.getSelectOne(dto);
		dto.setContent(dto.getContent().replace("\n", "<br>"));
		dto.setSearchData(searchData);
		dto.setSearchGubun(searchGubun);
		dto.setPageNumber_(pageNumber);
		model.addAttribute("title",title);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/sujung")
	public String sujung(
			Model model,
			BoardDTO dto
		) {
		String searchGubun = dto.getSearchGubun();
		String searchData = dto.getSearchData();
		String fileName = "sujung";
		
		dto = dao.getSelectOne(dto);
		dto.setSearchGubun(searchGubun);
		dto.setSearchData(searchData);
		String title = "게시글수정";
		model.addAttribute("title",title);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return folderName + "/" + fileName;
	}
	@RequestMapping("/sujungProc")
	public String sujungProc(
			Model model,
			BoardDTO dto
		) {
		String writer = dto.getWriter();
		String email = dto.getEmail();
		String subject = dto.getSubject();
		String content = util.getCheckString(dto.getContent());
		String noticeGubun = dto.getNoticeGubun();
		String secretGubun = dto.getSecretGubun();
		String searchGubun = dto.getSearchGubun();
		String searchData = dto.getSearchData();
		String pageNumber = dto.getPageNumber_();
		dto = dao.getSelectOne(dto);
		if(noticeGubun.equals("T")) {
			if(dto.getNoticeNo() <= 0) {
				dto.setNoticeNo(dao.getMaxValue("noticeNo")+1);
			}
		} else {
			if(dto.getNoticeNo() > 0 ) {
				dto.setNoticeNo(0);
			}
		}
		System.out.println(dto.getNoticeNo());
		dto.setWriter(writer);
		dto.setEmail(email);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setSecretGubun(secretGubun);
		dto.setSearchData(searchData);
		dto.setSearchGubun(searchGubun);
		System.out.println(dto.getSearchGubun());
		int result = dao.setUpdate(dto);
		if(result > 0 ) {
			return "redirect:/board/view?no="+dto.getNo()+"&pageNumber_="+ pageNumber +"&"+ dto.getSearchQuery();
		} else {
			return "redirect:/board/sujung?no="+dto.getNo()+"&pageNumber_="+ pageNumber +"&"+ dto.getSearchQuery();
		}
		
	}
	
	
	@RequestMapping("/search")
	public String search(
			Model model,
			BoardDTO dto
		) {
		String fileName = "list";
	
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return "redirect:/board/list?tbl="+dto.getTbl()+"&"+dto.getSearchQuery();
	}
	
	@RequestMapping("/sakje")
	public String sakje(
			Model model,
			BoardDTO dto
		) {
		String searchGubun = dto.getSearchGubun();
		String searchData = dto.getSearchData();
		String fileName = "sakje";
		
		dto = dao.getSelectOne(dto);
		dto.setSearchGubun(searchGubun);
		dto.setSearchData(searchData);
		String title = "게시글삭제";
		model.addAttribute("title",title);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(
			Model model,
			BoardDTO dto
		) {
	
		int result = dao.setDelete(dto);
		if(result > 0 ) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/sakje?no="+dto.getNo()+"&pageNumber_="+ dto.getPageNumber_() +"&"+ dto.getSearchQuery();
		}
		
	}
	
}
