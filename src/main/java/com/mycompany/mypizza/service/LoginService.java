package com.mycompany.mypizza.service;

import com.mycompany.mypizza.advice.ErrorCode;

public interface LoginService {
	public ErrorCode loginCheck(String email, String passwd);
	public String findId(String username);

}
