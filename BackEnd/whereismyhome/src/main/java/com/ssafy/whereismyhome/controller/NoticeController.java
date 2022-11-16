package com.ssafy.whereismyhome.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.dto.NoticeDto;
import com.ssafy.whereismyhome.dto.UserDto;
import com.ssafy.whereismyhome.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/notices")
public class NoticeController {
	
	private final NoticeService noticeService;

	@GetMapping
	protected ResponseEntity<?> getNoticeList(){
		
		List<NoticeDto> notices = noticeService.getNotices();
		if(notices != null) {
			return ResponseEntity.ok(notices);			
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/{no}")
	protected ResponseEntity<?> getNotice(@PathVariable int no){
		NoticeDto notice = noticeService.getNotice(no);
		if(notice != null) {
			noticeService.updateHit(no); // 조회수 증가 코드
			return ResponseEntity.ok(notice);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	protected ResponseEntity<?> register(@RequestBody NoticeDto notice){
		boolean res = noticeService.registerNotice(notice);
		
		if(res) {
			return ResponseEntity.created(URI.create("/notice/" + notice.getNo())).build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{no}")
	protected ResponseEntity<?> modify(@RequestBody NoticeDto notice){
		NoticeDto notice2 = noticeService.getNotice(notice.getNo());
		if(notice2 != null) {
			boolean res = noticeService.modifyNotice(notice);
			if(res) {
				return ResponseEntity.ok().body(notice);
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{no}")
	protected ResponseEntity<?> remove(@PathVariable int no){
		NoticeDto notice = noticeService.getNotice(no);
		if(notice!= null) {
			boolean res = noticeService.deleteNotice(no);
			if(res) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
