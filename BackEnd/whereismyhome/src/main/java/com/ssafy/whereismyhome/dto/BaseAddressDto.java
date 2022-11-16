package com.ssafy.whereismyhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseAddressDto {

	private int no;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String dongCode;
	private String lat;
	private String lng;
}
