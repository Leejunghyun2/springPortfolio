package com.LJH.springPortfolio.shopMall.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LJH.springPortfolio.shopMall.model.dao.CartDAO;
import com.LJH.springPortfolio.shopMall.model.dto.CartDTO;

@Controller
@RequestMapping("/shopCart")
public class ShopCartController {

	@Inject
	CartDAO dao;
	
	String folderName= "shopCart";
	
	@RequestMapping("/list")
	public String list(Model model) {
		String fileName = "list";
		String title = "장바구니";
		List<CartDTO> list = dao.getSelectAll();
		
		model.addAttribute("list",list);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		model.addAttribute("title",title);
		return "main/main";
	}
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model) {
		
		return "main/main";
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, CartDTO dto, HttpSession session) {
		if(session.getAttribute("sessionNo") != null) {
			dto.setMemberNo((int)session.getAttribute("sessionNo"));
		}
		
		
		int result = dao.setInsert(dto);
		if(result > 0) {
			return "redirect:/shopMall/list";
		} else {
			return "redirect:/shopMall/view?productCode_="+dto.getProductCode();
		}
	}
}
