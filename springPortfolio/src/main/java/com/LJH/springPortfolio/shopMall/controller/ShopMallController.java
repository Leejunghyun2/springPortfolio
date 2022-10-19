package com.LJH.springPortfolio.shopMall.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LJH.springPortfolio.shopMall.model.dao.ProductDAO;
import com.LJH.springPortfolio.shopMall.model.dao.VendorDAO;
import com.LJH.springPortfolio.shopMall.model.dto.CartDTO;
import com.LJH.springPortfolio.shopMall.model.dto.ProductDTO;

@Controller
@RequestMapping("/shopMall")
public class ShopMallController {

	@Inject
	ProductDAO productDao;
	@Inject
	VendorDAO vendorDao;
	
	String folderName = "shopMall";
	
	@RequestMapping("/list")
	public String list(Model model) {
		String fileName = "list";
		String title = "상품목록";
		
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		List<ProductDTO> productList = productDao.getSelectAll();
		
		model.addAttribute("productList",productList);
		
		return "main/main";
	}
	
	@RequestMapping("/view")
	public String view(Model model, ProductDTO dto) {
		String fileName = "view";
		String title = "상품정보";
		
		ProductDTO resultDto = productDao.getSelectOne(dto);
		
		model.addAttribute("productDto",resultDto);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return "main/main";
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(Model model, CartDTO dto) {
		String fileName = "list";
		
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return "main/main";
	}
	

	
}
