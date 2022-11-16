package com.ssafy.whereismyhome.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.dto.DongDto;
import com.ssafy.whereismyhome.dto.GugunDto;
import com.ssafy.whereismyhome.dto.SidoDto;
import com.ssafy.whereismyhome.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{

	private final AddressRepository addressRepository;
	
	@Override
	public List<SidoDto> getSidoList() {
		return addressRepository.selectSido();
	}

	@Override
	public List<GugunDto> getGugunList(String sidoCode) {
		return addressRepository.selectGugun(sidoCode);
	}

	@Override
	public List<DongDto> getDongList(String sidoCode, String gugunCode) {
		return addressRepository.selectDong(sidoCode + gugunCode);
	}

}
