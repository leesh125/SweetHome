package com.ssafy.whereismyhome.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.dto.InterestDto;

@Mapper
public interface InterestRepository {

	boolean insertInterest(InterestDto interest);

	InterestDto getInterest(int no);

	boolean deleteInterest(int no);

	List<InterestDto> getAllInterest();

	List<InterestDto> getAllInterestByUserId(String userId);

}
