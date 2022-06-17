package com.mycompany.mypizza.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mycompany.mypizza.advice.ErrorCode;

public interface NaverService {

	//네이버 로그인
	ErrorCode naverLogin(String code, String state, String path,HttpSession session) throws Exception;
	//로그인 apiUrl 생성
	Map<String, String> getApiUrl(String path) throws Exception;

}
