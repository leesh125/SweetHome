package com.ssafy.whereismyhome.service;

import java.util.List;

import com.ssafy.whereismyhome.dto.NoticeDto;

public interface NoticeService {

	List<NoticeDto> getNotices();

	NoticeDto getNotice(int no);

	void updateHit(int no);

	boolean registerNotice(NoticeDto notice);

	boolean modifyNotice(NoticeDto notice);

	boolean deleteNotice(int no);

}
