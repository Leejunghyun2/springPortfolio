package com.LJH.springPortfolio.shopMall.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LJH.springPortfolio.shopMall.model.dao.VendorDAO;
import com.LJH.springPortfolio.shopMall.model.dto.VendorDTO;

@Controller
@RequestMapping("/shopVendor")
public class VendorController {
	
	@Inject
	VendorDAO dao;
	
	String folderName = "shopVendor";
	
	@RequestMapping("/list")
	public String list(Model model) {
		String fileName = "list";
		String title = "제조사목록";
		List<VendorDTO> list = dao.getSelectAll();
		
		model.addAttribute("list", list);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/chuga")
	public String chuga(Model model) {
		String fileName = "chuga";
		String title = "제조사등록";
		
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, VendorDTO dto) {
		
		int result = dao.setInsert(dto); 
		if(result > 0) {
			System.out.println("추가성공");
			return "redirect:/shopVendor/list";	
		} else {
			System.out.println("추가실패");
			return "redirect:/shopVendor/chuga";
		}
	}
	
	@RequestMapping("/sujung")
	public String sujung(Model model, VendorDTO dto) {
		String fileName = "sujung";
		String title = "제조사수정";
		VendorDTO resultDto = dao.getSelectOne(dto);
		
		model.addAttribute("dto",resultDto);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, VendorDTO dto) {
		
		int result = dao.setUpdate(dto); 
		if(result > 0) {
			System.out.println("수정성공");
			return "redirect:/shopVendor/list";	
		} else {
			System.out.println("수정실패");
			return "redirect:/shopVendor/sujung?vendorCode_="+dto.getVendorCode_();
		}
	}
	
	@RequestMapping("/sakje")
	public String sakje(Model model, VendorDTO dto) {
		String fileName = "sakje";
		String title = "제조사삭제";
		VendorDTO resultDto = dao.getSelectOne(dto);
		
		model.addAttribute("dto",resultDto);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, VendorDTO dto) {
		
		int result = dao.setDelete(dto); 
		if(result > 0) {
			System.out.println("삭제성공");
			return "redirect:/shopVendor/list";	
		} else {
			System.out.println("삭제실패");
			return "redirect:/shopVendor/sakje?vendorCode_="+dto.getVendorCode_();
		}
	}
	
		
}
