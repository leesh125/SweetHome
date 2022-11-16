package com.ssafy.whereismyhome.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.dto.NoticeDto;

@Mapper
public interface NoticeRepository {

	List<NoticeDto> selectNotices();

	NoticeDto selectNotice(int no);

	void updateHit(int no);

	boolean insertNotice(NoticeDto notice);

	boolean updateNotice(NoticeDto notice);

	boolean deleteNotice(int no);

}
