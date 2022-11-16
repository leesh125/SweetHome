package com.ssafy.whereismyhome.service;

import java.util.List;

import com.ssafy.whereismyhome.dto.DongDto;
import com.ssafy.whereismyhome.dto.GugunDto;
import com.ssafy.whereismyhome.dto.SidoDto;

public interface AddressService {
	List<SidoDto> getSidoList();
	List<GugunDto> getGugunList(String sidoCode);
	List<DongDto> getDongList(String sidoCode, String gugunCode);
}
