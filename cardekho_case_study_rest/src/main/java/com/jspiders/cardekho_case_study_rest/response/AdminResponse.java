package com.jspiders.cardekho_case_study_rest.response;

import com.jspiders.cardekho_case_study_rest.pojo.AdminPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
	
	private String msg ;
	private AdminPOJO admin ;

}
