package com.LJH.springPortfolio.chart.controller;

import java.util.List;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LJH.springPortfolio._common.ChartService;
import com.LJH.springPortfolio.shopMall.model.dao.CartDAO;
import com.LJH.springPortfolio.shopMall.model.dto.CartDTO;

@Controller
@RequestMapping("/chart")
public class ChartController {
	
	@Inject
	CartDAO cartDao;
	
	
	String folderName = "chart";
	
	@RequestMapping("/dbChart")
	public String dbChart(Model model) {
		 
	   	String fileName = "dbChart";
	   	
	   	model.addAttribute("folderName",folderName);
	   	model.addAttribute("fileName",fileName);
		return "main/main";
	}
	
	@RequestMapping("/dbChartProc")
	public String dbChartProc(Model model) {
		List<CartDTO> list = cartDao.getSelectCartProductGroup();
		ChartService service = new ChartService();
	   	JSONObject json = service.getChartData(list);
	   	model.addAttribute("json",json);
		return "chart/dbChartProc";
	}
}
