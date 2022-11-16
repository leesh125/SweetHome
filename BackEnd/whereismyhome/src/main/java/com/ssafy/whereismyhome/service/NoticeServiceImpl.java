package com.ssafy.whereismyhome.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.dto.NoticeDto;
import com.ssafy.whereismyhome.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;
	
	@Override
	public List<NoticeDto> getNotices() {
		return noticeRepository.selectNotices();
	}

	@Override
	public NoticeDto getNotice(int no) {
		return noticeRepository.selectNotice(no);
	}

	@Override
	public void updateHit(int no) {
		noticeRepository.updateHit(no);
	}

	@Override
	public boolean registerNotice(NoticeDto notice) {
		return noticeRepository.insertNotice(notice);
	}

	@Override
	public boolean modifyNotice(NoticeDto notice) {
		return noticeRepository.updateNotice(notice);
	}

	@Override
	public boolean deleteNotice(int no) {
		return noticeRepository.deleteNotice(no);
	}

}
