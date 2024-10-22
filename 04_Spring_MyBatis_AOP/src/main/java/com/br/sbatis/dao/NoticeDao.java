package com.br.sbatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.br.sbatis.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class NoticeDao {
	
	private final SqlSessionTemplate sqlSession;
	
	// 리스트 조회시 selectList 사용
	public List<NoticeDto> selectNoticeList(){
		return sqlSession.selectList("noticeMapper.selectNoticeList");
	}
	
	// 리스트 하나만 조회시 selectOne 사용 하고 SQL(맵퍼에서) 완성시킬 무언가를 사용해야되니깐 noticeNo 필요함
	public NoticeDto selectNoticeByNo(int noticeNo) {
		return sqlSession.selectOne("noticeMapper.selectNoticeByNo", noticeNo);
	}
	
	// return sqlSession 이후에 sql문에서 실행할 명령문 작성
	public int insertNotice(NoticeDto n) {
		return sqlSession.insert("noticeMapper.insertNotice", n);
	}
	
	public int updateNotice(NoticeDto n) {
		return sqlSession.update("noticeMapper.updateNotice", n);
	}
	
	public int deleteNotice(String[] deleteNo) {
		return sqlSession.delete("noticeMapper.deleteNotice", deleteNo);
	}
	
	
	

}
