package com.ssafy.whereismyhome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HouseSearchDto {
	private String locationCode;
	private String searchWord;
	private int searchOrder;
}
