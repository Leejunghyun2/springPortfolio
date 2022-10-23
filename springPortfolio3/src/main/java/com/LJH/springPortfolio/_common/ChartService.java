package com.LJH.springPortfolio._common;

import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

import com.LJH.springPortfolio.shopMall.model.dto.CartDTO;

public class ChartService {
	
	
	
	public JSONObject getChartData(List<CartDTO> list) {
		
		
		//리턴할 json 객체
		JSONObject data = new JSONObject();
		//컬럼구성
		JSONObject col1 =new JSONObject();
		JSONObject col2 =new JSONObject();
		JSONArray title = new JSONArray(); 
	    
		col1.put("label", "상품명"); //key, value
		col1.put("type", "string"); //key, value
		
		
		col2.put("label", "금액"); //key, value 컬럼이름
		col2.put("type", "number"); //key, value 컬럼자료형
		
		title.put(col1);
		title.put(col2);
		data.put("cols", title); //컬럼에 객체 추가..
		
		JSONArray body = new JSONArray();
		for(CartDTO dto : list) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getProductName());
			
			JSONObject money = new JSONObject();
			money.put("v", dto.getBuyMoney());
			
			JSONArray row = new JSONArray();
			row.put(name);
			row.put(money);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.put(cell);
		}
		data.put("rows", body);
		return data;
	}
}
