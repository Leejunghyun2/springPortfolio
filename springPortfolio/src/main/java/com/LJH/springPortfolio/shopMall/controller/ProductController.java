package com.LJH.springPortfolio.shopMall.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.LJH.springPortfolio._common.Constants;
import com.LJH.springPortfolio._common.MultipartUpload;
import com.LJH.springPortfolio._common.Util;
import com.LJH.springPortfolio.shopMall.model.dao.ProductDAO;
import com.LJH.springPortfolio.shopMall.model.dao.VendorDAO;
import com.LJH.springPortfolio.shopMall.model.dto.ProductDTO;
import com.LJH.springPortfolio.shopMall.model.dto.VendorDTO;


@Controller
@RequestMapping("/shopProduct")
public class ProductController {
	
	@Inject
	ProductDAO productDao;
	@Inject
	VendorDAO vendorDao;
	String folderName = "shopProduct";
	
	@RequestMapping("/list")
	public String list(Model model) {
		String fileName = "list";
		String title = "상품목록";
		List<ProductDTO> list = productDao.getSelectAll();
		
		model.addAttribute("list",list);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return "main/main";
	}
	
	@RequestMapping("/chuga")
	public String chuga(Model model) {
		String fileName = "chuga";
		String title = "상품등록";
		
		
		List<VendorDTO> vendorList = vendorDao.getSelectAll();
		
		model.addAttribute("vendorList",vendorList);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return "main/main";
	}
	
	@RequestMapping("/chugaProc")
	public String chugaProc(
			Model model,
			HttpServletRequest request,
			@ModelAttribute ProductDTO dto,
			@RequestParam("file") List<MultipartFile> multiFileList
		) {
		MultipartUpload mu = new MultipartUpload();
		List<String> list = mu.attachProc(multiFileList, "/springPortfolio/product");
		String attachInfo = "";
		for(int i=0; i<list.size(); i++) {
			attachInfo += "|" + list.get(i);
		}
		attachInfo = attachInfo.substring(1);
		dto.setAttachInfo(attachInfo);
		System.out.println(dto.getAttachInfo());
		int result = productDao.setInsert(dto);
		
		String url = "";
		if(result > 0) {
			url = "list";
		} else {
			url = "chuga";
		}
		return "redirect:/shopProduct/" + url;
	}
	
	@RequestMapping("/sujung")
	public String sujung(Model model, ProductDTO dto) {
		String fileName = "sujung";
		String title = "상품수정";
		ProductDTO resultDto = productDao.getSelectOne(dto);
		List<VendorDTO> vendorList = vendorDao.getSelectAll();
		
		model.addAttribute("vendorList",vendorList);
		model.addAttribute("dto",resultDto);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return "main/main";
	}
	
	@RequestMapping("/sujungProc")
	public String sujungProc(Model model, ProductDTO dto, Util util) {
		String productName = dto.getProductName();
		int productPrice =util.getNumberCheck(dto.getProductPrice_(),-1);
		if(productPrice < 0) {
			return "redirect:/shopProduct/sujung?productCode_="+dto.getProductCode();
		}
		ProductDTO resultDto = productDao.getSelectOne(dto);
		String[] file = new String[3];
		MultipartUpload mu = new MultipartUpload();
		String path = Constants.ATTACH_PATH;
		String uploadPath = path + "/springPortfolio/product/";
		String attachInfo = "";
		
		String newFileName = "";
		System.out.println(resultDto.getAttachInfo());
		System.out.println("attach:"+resultDto.getAttachInfo());
		String[] imsiArray = resultDto.getAttachInfo().split("[|]");
		for(int i=0; i < imsiArray.length; i++) {
			if(!imsiArray[i].equals("-")) {
				System.out.println(imsiArray[i]);
				String[] imgFile = imsiArray[i].split(",");
				file[i] = imgFile[1];
			} else {
				file[i] = imsiArray[i];
			}
		}
		if(!(file[0].equals("-") && dto.getFile_0().getOriginalFilename().equals(""))) {
			if(!(file[0].equals("-")) && dto.getFile_0().getOriginalFilename().equals("")) {
				
			} else {
				newFileName = mu.attachUpdateProc(dto.getFile_0(), "/springPortfolio/product");
				if(!(file[0].equals("-"))){
					File f1 = new File(uploadPath + file[0]);
					if(f1.exists()) {
						f1.delete();
					}
				}
				imsiArray[0] = newFileName;
			}
		}
		if(!(file[1].equals("-") && dto.getFile_1().getOriginalFilename().equals(""))) {
			if(!(file[1].equals("-")) && dto.getFile_1().getOriginalFilename().equals("")) {
				
			} else {
				newFileName = mu.attachUpdateProc(dto.getFile_1(), "/springPortfolio/product");
				if(!(file[1].equals("-"))){
					File f2 = new File(uploadPath + file[1]);
					if(f2.exists()) {
						f2.delete();
					}
				}
				imsiArray[1] = newFileName;
			}
		}
		if(!(file[2].equals("-") && dto.getFile_2().getOriginalFilename().equals(""))) {
			if(!(file[2].equals("-")) && dto.getFile_2().getOriginalFilename().equals("")) {
				
			} else {
				newFileName = mu.attachUpdateProc(dto.getFile_2(), "/springPortfolio/product");
				if(!(file[2].equals("-"))){
					File f3 = new File(uploadPath + file[2]);
					if(f3.exists()) {
						f3.delete();
					}
				}
				imsiArray[2] = newFileName;
			}
		}
		attachInfo += imsiArray[0] + "|";
		attachInfo += imsiArray[1] + "|";
		attachInfo += imsiArray[2];
		
		int vendorCode = dto.getVendorCode();
		resultDto.setAttachInfo(attachInfo);
		resultDto.setProductName(productName);
		resultDto.setProductPrice(productPrice);
		resultDto.setVendorCode(vendorCode);
		
		int result = productDao.setUpdate(resultDto);
		if(result > 0) {
			return "redirect:/shopProduct/list";
		} else {
			return "redirect:/shopProduct/sujung?productCode_="+dto.getProductCode();
		}
		
		
	}
	@RequestMapping("/sujungProc1")
	public String sujungProc1(Model model, ProductDTO dto, Util util) {
	
		ProductDTO resultDto = productDao.getSelectOne(dto);
		String[] file = new String[3];
		MultipartUpload mu = new MultipartUpload();
		String path = Constants.ATTACH_PATH;
		String uploadPath = path + "/springPortfolio/product/";
		
		
		System.out.println("1:" +dto.getFile_0().getOriginalFilename()); 
		System.out.println("2:" +dto.getFile_1().getOriginalFilename());
		System.out.println("3:" +dto.getFile_2().getOriginalFilename());
		System.out.println("attach:"+resultDto.getAttachInfo());
		String[] imsiArray = resultDto.getAttachInfo().split("[|]");
		for(int i=0; i < imsiArray.length; i++) {
			if(!imsiArray[i].equals("-")) {
				System.out.println(imsiArray[i]);
				String[] imgFile = imsiArray[i].split(",");
				file[i] = imgFile[1];
			} else {
				file[i] = imsiArray[i];
			}
		}
		if(!(file[0].equals("-") && dto.getFile_0().getOriginalFilename().equals(""))) {
			if(!(file[0].equals("-")) && dto.getFile_0().getOriginalFilename().equals("")) {
				
			} else {
				mu.attachUpdateProc(dto.getFile_0(), "/springPortfolio/product");
				if(!(file[0].equals("-"))){
					File f1 = new File(uploadPath + file[0]);
					if(f1.exists()) {
						f1.delete();
					}
				}
			}
		}
		if(!(file[1].equals("-") && dto.getFile_1().getOriginalFilename().equals(""))) {
			if(!(file[1].equals("-")) && dto.getFile_1().getOriginalFilename().equals("")) {
				
			} else {
				mu.attachUpdateProc(dto.getFile_1(), "/springPortfolio/product");
			}
		}
		if(!(file[2].equals("-") && dto.getFile_2().getOriginalFilename().equals(""))) {
			if(!(file[2].equals("-")) && dto.getFile_2().getOriginalFilename().equals("")) {
				
			} else {
				mu.attachUpdateProc(dto.getFile_2(), "/springPortfolio/product");
			}
		}
		System.out.println(file[0]);
		System.out.println(file[1]);
		System.out.println(file[2]);
		
		
		return "redirect:/shopProduct/sujung?productCode_="+dto.getProductCode();
	}
	
	
	@RequestMapping("/sakje")
	public String sakje(Model model,ProductDTO dto) {
		String fileName = "sakje";
		String title = "상품삭제";
		ProductDTO resultDto = productDao.getSelectOne(dto);
		List<VendorDTO> vendorList = vendorDao.getSelectAll();
		
		model.addAttribute("vendorList",vendorList);
		model.addAttribute("dto",resultDto);
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return "main/main";
	}
	
	@RequestMapping("/sakjeProc")
	public String sakjeProc(Model model, ProductDTO dto) {
		
		dto = productDao.getSelectOne(dto);
		String attachInfo = dto.getAttachInfo();
		
		
		
		int result = productDao.setDelete(dto);
		if(result > 0) {
			String[] imsiArray = attachInfo.split("[|]");
			for(int i = 0; i < imsiArray.length; i++) {
				if(!imsiArray[i].equals("-")) {
					String[] imgArray = imsiArray[i].split(",");
					String path = Constants.ATTACH_PATH + "/springPortfolio/product";
					String uploadPath = path + "/" + imgArray[1];
					System.out.println(uploadPath);
					File f1 = new File(uploadPath);
					if(f1.exists()) {
						System.out.println("삭제완료");
						f1.delete();
					}
				}
			}
			return "redirect:/shopProduct/list";
		} else {
			return "redirect:/shopProduct/sakje?productCode_="+dto.getProductCode();
		}
		
		
	}
	
	@RequestMapping("/view")
	public String view(Model model) {
		String fileName = "view";
		String title = "상품목록";
		
		model.addAttribute("title",title);
		model.addAttribute("folderName",folderName);
		model.addAttribute("fileName",fileName);
		
		return "main/main";
	}
	
}
