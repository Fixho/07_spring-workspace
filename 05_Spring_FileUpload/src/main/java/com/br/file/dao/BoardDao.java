package com.br.file.dao;

import org.mybatis.spring.SqlSessionTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardDao {
	
	private final SqlSessionTemplate sqlSession;
	

}
