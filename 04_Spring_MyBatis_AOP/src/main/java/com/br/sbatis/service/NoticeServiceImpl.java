package com.br.sbatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.sbatis.dao.NoticeDao;
import com.br.sbatis.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService{
// implements ooo서비스 구문 쓰면 인터페이스에 있는 서비스가 오버라이딩 됨
	
	private final NoticeDao noticeDao;
	
	@Override
	public List<NoticeDto> selectNoticeList() {
		return noticeDao.selectNoticeList();
	}

	@Override
	public NoticeDto selectNoticeByNo(int noticeNo) {
		return null;
	}

	@Override
	public int insertNotice(NoticeDto n) {
		return 0;
	}

	@Override
	public int updateNotice(NoticeDto n) {
		return 0;
	}

	@Override
	public int deleteNotice(String[] deleteNo) {
		return 0;
	}
	
	

}
