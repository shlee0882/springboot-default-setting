package com.example.demo.api.model.burger;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class BurgerVO implements Serializable {

	  private Integer productNo;	
	  private String chainNo;     	
	  private String chainName;     
	  private String menuName;      
	  private String singlePrice;	
	  private String setPrice;		
	  private String calory;		
	  private String displayYn;     
	  private String storeNo;       
	  private String imgUrl;        
	  private String storeName;     
	  private String areaCode;      
	  private String totalCount;      
	  private Integer result;		
	
	  private List<String> burgerList;
}
