package com.LJH.springPortfolio._common;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import com.LJH.springPortfolio.member.model.dto.MemberDTO;

public class Util {
	public String getIp() throws UnknownHostException{
		String ip = "0.0.0.0";
		ip = Inet4Address.getLocalHost().getHostAddress();
		String result = ip;
		return result;
	}
	public int getNumberCheck(String str, int defaultStr) {
		int result = 0;

		String temp = str;

		if (temp == null || temp.trim().equals("")) {
			temp = "-";
		}
		for (int i = 0; i <= 9; i++) {
			temp = temp.replace(i + "", "");
		}
		if (temp.equals("")) {// 숫자로만 구성된
			result = Integer.parseInt(str);
		} else {
			result = defaultStr;
		}

		return result;
	}
	
	public String getCheckString(String str) {
		String result = str;
		 result = result.replace("&", "&amp;");
		 result = result.replace("<", "&lt;");
		 result = result.replace(">", "&gt;");
		 result = result.replace("\"", "&quot;");
		 result = result.replace("'", "&apos;");
		 return result;
	}
	public String[] getServerInfo(HttpServletRequest request) throws UnknownHostException {
		// 이걸사용 하기 위해 HttpServletRequest 써줘야함
		// 이전페이지주소가 뭔지 알아내는 변수
		//String referer = request.getHeader("REFERER");
	//	if (referer == null || referer.trim().equals("")) {
	//		referer = "";
	//	}

		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();
		String ip = Inet4Address.getLocalHost().getHostAddress();

		String ip6 = request.getHeader("X-Forwarded-For");
		if (ip6 == null || ip6.length() == 0 || "unknown".equalsIgnoreCase(ip6)) {
			ip6 = request.getHeader("Proxy-Client-IP");
		}
		if (ip6 == null || ip6.length() == 0 || "unknown".equalsIgnoreCase(ip6)) {
			ip6 = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip6 == null || ip6.length() == 0 || "unknown".equalsIgnoreCase(ip6)) {
			ip6 = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip6 == null || ip6.length() == 0 || "unknown".equalsIgnoreCase(ip6)) {
			ip6 = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip6 == null || ip6.length() == 0 || "unknown".equalsIgnoreCase(ip6)) {
			ip6 = request.getRemoteAddr();
		}
		
		String[] imsiUriArray = uri.split("/");
		String imsiUriFileName = imsiUriArray[imsiUriArray.length - 1];
		imsiUriFileName = imsiUriFileName.replace(".do", ""); //dashBoard_index
		if(imsiUriFileName.equals("jspPortfolioModel2")) {
			imsiUriFileName = "dashBoard_index.do";
		}
	
		String[] imsiArray = imsiUriFileName.split("_"); 
		String folderName = imsiArray[0];
		String fileName = imsiArray[1];
	
		
		if(imsiUriFileName.equals(".do")) { 

		} else if(imsiUriFileName.equals("01Proc.do")){
			
		}

		String[] array = new String[8];
		//array[0] = referer;
		array[1] = path;
		array[2] = url;
		array[3] = uri;
		array[4] = ip;
		array[5] = ip6;
		array[6] = folderName;
		array[7] = fileName;
		
		return array;
	}
}
