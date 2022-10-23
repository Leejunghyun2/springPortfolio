package com.LJH.springPortfolio.member.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LJH.springPortfolio._common.Util;
import com.LJH.springPortfolio.member.model.dao.MemberDAO;
import com.LJH.springPortfolio.member.model.dto.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {
	String folderName = "member";
	
	@Inject
	MemberDAO dao;
	
	Util util = new Util();
	
	
	
	@RequestMapping("/list")
	public String list(
			Model model,
			MemberDTO dto
		) {
		
		String fileName = "list";
		String title = "회원목록";
		int pageNumber = util.getNumberCheck(dto.getPageNumber_(),1);
		
		int pageSize = 2;
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
		
		List<MemberDTO> list = dao.getSelectAll(dto); 
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
		return folderName + "/" + fileName;
	}

	@RequestMapping("/chuga")
	public String chuga(
			Model model,
			MemberDTO dto
		) {
		String fileName = "chuga";
		String title = "회원등록";
		model.addAttribute("title",title);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(
			Model model,
			MemberDTO dto
		) {
		String fileName = "chuga";
		
		
		int result = dao.setInsert(dto);
		if(result > 0) {
			fileName = "list";
		}
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return "redirect:/member/"+fileName;
	}
	
	@RequestMapping("/search")
	public String search(
			Model model,
			MemberDTO dto
		) {
		String fileName = "list";
	
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return "redirect:/member/list?"+dto.getSearchQuery();
	}
	
	@RequestMapping("/view")
	public String view(
			Model model,
			MemberDTO dto
		) {
		String searchGubun = dto.getSearchGubun();
		String searchData = dto.getSearchData();
		String pageNumber = dto.getPageNumber_();
		String title = "회원상세보기";
		
		String fileName = "view";
		dto = dao.getSelectOne(dto);
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
			MemberDTO dto
		) {
		String searchGubun = dto.getSearchGubun();
		String searchData = dto.getSearchData();
		String fileName = "sujung";
		
		dto = dao.getSelectOne(dto);
		dto.setSearchGubun(searchGubun);
		dto.setSearchData(searchData);
		String title = "회원수정";
		model.addAttribute("title",title);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/sujungProc")
	public String sujungProc(
			Model model,
			MemberDTO dto
		) {
		int result = dao.setUpdate(dto);
		if(result > 0) {
			return "redirect:/member/view?no_="+ dto.getNo_() + "&" + dto.getSearchQuery();
		}else {
			return "redirect:/member/sujung?no_="+ dto.getNo_() + "&" + dto.getSearchQuery();
		}
	}
	
	@RequestMapping("/sakje")
	public String sakje(
			Model model,
			MemberDTO dto
		) {
		String searchGubun = dto.getSearchGubun();
		String searchData = dto.getSearchData();
		String fileName = "sakje";
		dto = dao.getSelectOne(dto);
		
		dto.setSearchGubun(searchGubun);
		dto.setSearchData(searchData);
		
		String title = "회원삭제";
		model.addAttribute("title",title);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(
			Model model,
			MemberDTO dto
		) {
		int result = dao.setDelete(dto);
		if(result > 0) {
			return "redirect:/member/list";
		}else {
			return "redirect:/member/sakje?no_="+ dto.getNo() + "&" + dto.getSearchQuery();
		}
	}
	
	@RequestMapping("/login")
	public String login(
			Model model,
			@ModelAttribute MemberDTO dto
		) {
		String fileName = "login";
		String title = "회원로그인";
		model.addAttribute("title",title);
		model.addAttribute("fileName", fileName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("dto",dto);
		
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/loginProc")
	public String loginProc(
			Model model,
			HttpSession session,
			@ModelAttribute MemberDTO dto
		) {
		String title = "로그인";
		model.addAttribute("title",title);
		dto = dao.getLogin(dto);
		if(dto.getNo() > 0) {
			session.setAttribute("sessionNo", dto.getNo());
			session.setAttribute("sessionName", dto.getName());
			session.setAttribute("sessionEmail", dto.getEmail1()+"@"+dto.getEmail2());
			return "redirect:/member/list";
		} else {
			return "redirect:/member/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(
			Model model,
			HttpSession session
		) {
		
		session.invalidate();
		
		return "redirect:/member/login";
	}
	
	
	
	
	
	//ajax Test용
	
	@RequestMapping("/list1")
	public String list1(
			Model model,
			MemberDTO dto
		) {
		
		String fileName = "list";
		String title = "회원목록";
		int pageNumber = util.getNumberCheck(dto.getPageNumber_(),1);
		
		int pageSize = 2;
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
		
		List<MemberDTO> list = dao.getSelectAll(dto); 
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
		return "member/list";
	}
	
}
