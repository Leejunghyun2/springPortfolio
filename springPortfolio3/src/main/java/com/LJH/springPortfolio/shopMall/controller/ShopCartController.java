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
		return folderName + "/" + fileName;
	}
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, String[] chk) {
		CartDTO cartDto = new CartDTO();
		if(chk.length > 0) {
			for(int i=0; i < chk.length; i++) {
				cartDto.setCartNo_(chk[i]);
				dao.setDelete(cartDto);
			}
		}
		return "redirect:/shopCart/list";
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, CartDTO dto, HttpSession session) {
		if(session.getAttribute("sessionNo") != null) {
			dto.setMemberNo((int)session.getAttribute("sessionNo"));
		}
		System.out.println(dto.getAmount());
		
		int result = dao.setInsert(dto);
		if(result > 0) {
			return "redirect:/shopMall/list";
		} else {
			return "redirect:/shopMall/view?productCode_="+dto.getProductCode();
		}
	}
}
