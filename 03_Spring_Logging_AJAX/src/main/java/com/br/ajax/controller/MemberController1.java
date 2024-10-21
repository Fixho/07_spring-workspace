package com.br.ajax.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.ajax.dto.MemberDto;
import com.br.ajax.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/member1")
@RequiredArgsConstructor
@Controller
public class MemberController1 {
   
   //내가주입받고자 하는 필드에 final붙이고 lombok처리
   private final MemberService memService;
   //조회 잘 됐는지 로그 출력(얘는 final붙이지 않는다)
   private Logger logger = LoggerFactory.getLogger(MemberController1.class);
   
   /*
   @GetMapping("/detail1.do")
   public void memberDetail(String id, String pwd,HttpServletResponse response) throws IOException {
      logger.debug("request id: {}, pwd: {}",id,pwd);
      String result = memService.selectMemberByIdPwd(id, pwd);
      
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.print(result);
   }
   */
   //아이디와 비번으로 이름 조회
   @ResponseBody//응답 뷰페이지 아니고 응답 데이터 보낸 거라고 지정하는 @
   @GetMapping(value="/detail1.do", produces="text/html; charset=utf-8")
   public String memberDetail(String id, String pwd) {//ajax id지정명
      logger.debug("request id: {}, pwd: {}",id,pwd);
      String result = memService.selectMemberByIdPwd(id, pwd);

      //@ResponseBody안쓰고 하면 스프링이 문자열반환?응답 뷰 명이구나!라고 판단
      return result;
   }
   
   @ResponseBody
   @GetMapping(value="/detail2.do",produces="text/html; charset=utf-8")
   public String memberDetail2(String userId, String userPwd) {//serialize
      return memService.selectMemberByIdPwd(userId, userPwd);
   }
   
   
   @ResponseBody
   @GetMapping(value="/detail3.do",produces="application/json")
    public MemberDto memberDetail3(@RequestParam(value="no",defaultValue="1") int userNo) {
      MemberDto mem = memService.selectMemberByNo(userNo);
      return mem;//{필드명:필드값,필드명:필드값,필드명:필드값,,,}형태로 반환
   }
   
   @ResponseBody
   @GetMapping(value="list.do", produces="application/json")
   public List<MemberDto> memberList() {
      List<MemberDto> list = memService.selectMemberList();
      return list;//[{},{}]
   }
   
   @ResponseBody
   @GetMapping(value="etc1.do", produces="application/json")
   public Map<String, Object> responseMapTest() {
	   // 만일 응답할 데이터로 숫자, List, Dto가 있다는 가정하에
	   Map<String, Object> map = new HashMap<>();
	   map.put("no", 1);
	   map.put("list", memService.selectMemberList());
	   map.put("m", memService.selectMemberByNo(2));
   
	   return map;
	   /*
	    * {
	    * 	no: 1,
	    * 	list: [{}, {}, {}],
	    * 	m: {}
	    * }
	    */
   
   }
   
   @ResponseBody
   @PostMapping(value="/etc2.do")
   public void requestBodyTest(@RequestBody Map<String, Object> map) {
	   logger.debug("map: {}", map);
	   logger.debug("map>no: {}", map.get("no"));
	   logger.debug("map>name: {}", map.get("name"));
	   logger.debug("map>arr: {}", map.get("arr"));
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
