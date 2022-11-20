package com.ssafy.whereismyhome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class LatLngDto {
	private String dongCode;
	private String lat;
	private String lng;
}
