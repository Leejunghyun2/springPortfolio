package com.LJH.springPortfolio._home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	String folderName = "_home";
	
	@RequestMapping("/")
	public String home(Model model) {
		
		String fileName = "main";
		
		model.addAttribute("fileName",fileName);
		model.addAttribute("folderName",folderName);
		
		return "main/main";
	}
	
	@RequestMapping("/_home/index")
	public String index(Model model) {
		
		String fileName = "index";
		
		model.addAttribute("fileName",fileName);
		model.addAttribute("folderName",folderName);
		
		return "_home/index";
	}
}
