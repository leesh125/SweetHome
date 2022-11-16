package com.ssafy.whereismyhome.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.dto.InterestDto;
import com.ssafy.whereismyhome.repository.InterestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InterestServiceImpl implements InterestService {

	private final InterestRepository interestRepository;
	
	@Override
	public boolean registerInterest(InterestDto interest) {
		return interestRepository.insertInterest(interest);
	}

	@Override
	public InterestDto getInterest(int no) {
		return interestRepository.getInterest(no);
	}

	@Override
	public boolean deleteInterest(int no) {
		return interestRepository.deleteInterest(no);
	}

	@Override
	public List<InterestDto> getAllInterest() {
		return interestRepository.getAllInterest();
	}

	@Override
	public List<InterestDto> getAllInterestByUserId(String userId) {
		return interestRepository.getAllInterestByUserId(userId);
	}

}
