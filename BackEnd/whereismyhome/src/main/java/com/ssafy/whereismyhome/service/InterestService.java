package com.ssafy.whereismyhome.service;

import java.util.List;

import com.ssafy.whereismyhome.dto.InterestDto;

public interface InterestService {

	boolean registerInterest(InterestDto interest);

	InterestDto getInterest(int no);

	boolean deleteInterest(int no);

	List<InterestDto> getAllInterest();

	List<InterestDto> getAllInterestByUserId(String userId);

}
