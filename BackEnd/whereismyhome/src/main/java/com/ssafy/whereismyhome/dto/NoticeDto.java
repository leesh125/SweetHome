package com.ssafy.whereismyhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDto {
	private int no;
	private String subject;
	private String content;
	private String author;
	private String createDate;
	private int hit;
	
	
}
