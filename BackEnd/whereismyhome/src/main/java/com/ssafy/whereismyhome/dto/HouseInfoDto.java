package com.ssafy.whereismyhome.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseInfoDto {
	
	private int aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	private BaseAddressDto baseAddressDto;
	private List<HouseDealDto> houseDealDtos;
}
