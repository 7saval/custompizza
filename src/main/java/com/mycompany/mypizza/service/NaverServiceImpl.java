package com.mycompany.mypizza.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Member;
import com.mycompany.mypizza.repository.MemberRepository;

@Service
public class NaverServiceImpl implements NaverService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	//네이버 콜백 url
//	String naverRedirectUrl = "http://localhost:8081";
	String naverRedirectUrl = "http://118.67.131.101:8080"; //실서버용
	
	//네이버 로그인
	@Override
	public ErrorCode naverLogin(String code, String state, String path, HttpSession session) throws Exception {
		//code, msg
		//0 : 로그인 성공, 간편가입 완료
		//1 : 네이버 간편가입 아님
		
		//토큰 생성(토큰을 이용해서 개인정보 얻을 수 있다)
		String access_token= getAccessToken(code, state, path);
		//개인정보얻기
		Member member = getUserInfo(access_token);
		//네이버간편가입 정보 db에서 조회
		Member dbmember = memberRepository.selectOne(member.getEmail());
		//이미 가입이 되어 있다면
		if(dbmember!=null) {
			//네이버 간편가입한 회원 아니라면(네이버이메일 씀)
			if(!dbmember.getSimplejoin().equals("1")) {
				return ErrorCode.ERROR_NAVER_NOTSIMPLEJOIN;
			}else {
				//이미 간편가입으로 가입한 사람
				//로그인(세션 저장)
				session.setAttribute("email", member.getEmail());
				return ErrorCode.SUCCESS_NAVER_LOGIN;
			}
		}
		//가입된 정보가 없다면 저장
		insert_simplejoin(member);
		//로그인(세션 저장)
		session.setAttribute("email", member.getEmail());
		return ErrorCode.SUCCESS_NAVER_JOIN;
	}
	//document - API명세 - 로그인 API명세 - API호출예제 - JSP(1.naverlogin.jsp)긁어오기
	@Override
	public Map<String, String> getApiUrl(String path) throws Exception{
		//네이버 로그인을 위한 apiUrl과 state값 리턴
		Map<String, String> rmap = new HashMap<>();
		
		String clientId = "RqdQl857bohpIHc10vAA";//애플리케이션 클라이언트 아이디값";
	    String redirectURI = URLEncoder.encode(naverRedirectUrl+path+"/naverCallback", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    //HomeController에서 저장
	    //session.setAttribute("state", state);
	    rmap.put("apiURL", apiURL);
	    rmap.put("state", state);
	    
	    return rmap;
	}
	
	//document - API명세 - 로그인 API명세 - API호출예제 - JSP(2.callback.jsp)긁어오기
	private String getAccessToken(String code, String state, String path) throws Exception {
		//accessToken변환
		//토큰 가져오기
		String clientId = "RqdQl857bohpIHc10vAA";
		String clientSecret = "bu2R9ySE62";
		String access_token = "";
		
		String redirectURI = URLEncoder.encode(naverRedirectUrl+path+"/naverCallback", "UTF-8");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;

	    System.out.println("apiURL="+apiURL);
	    
	    URL url = new URL(apiURL);
	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
	    con.setRequestMethod("GET");
	    int responseCode = con.getResponseCode();
	    BufferedReader br;
	    System.out.print("responseCode="+responseCode);
	    if(responseCode==200) { // 정상 호출
	      br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    } else {  // 에러 발생
	      br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	    }
	    String inputLine;
	    StringBuffer res = new StringBuffer();
	    while ((inputLine = br.readLine()) != null) {
	      res.append(inputLine);
	    }
	    br.close();
	    if(responseCode==200) {
	      System.out.println(res.toString());
	        
	      // json파싱 : access_token 토큰 얻기
	      JSONObject object = (JSONObject) new JSONParser().parse(res.toString());
	      access_token = (String) object.get("access_token");
	    }
	    return access_token;	    
	}

	//document - API명세 - 회원프로필조회 API명세 - API호출예제 - java긁어오기
	private Member getUserInfo(String access_token) throws Exception {
		//토큰을 이용해서 개인정보 요청
		Member member = null; //반환
	    String header = "Bearer " + access_token; // Bearer 다음에 공백 추가
        String apiURL = "https://openapi.naver.com/v1/nid/me";
        HttpURLConnection con = null;
        BufferedReader br = null;

	    URL url = new URL(apiURL);
	    con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", header);
		int responseCode = con.getResponseCode();
		
		if(responseCode==200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {  // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		
		//json파싱
    	JSONObject object = (JSONObject) new JSONParser().parse(res.toString());
    	object = (JSONObject) object.get("response");
    	String id = (String) object.get("id");
    	String email = (String) object.get("email");
    	String name = (String) object.get("name");
    	String mobile = (String) object.get("mobile");
    	
    	//멤버 객체 생성
    	member = new Member();
    	member.setEmail(email);
    	member.setUsername(name);
    	member.setMobile(mobile);
    	
    	//개인정보 반환
		return member;
		
	}
	
	private void insert_simplejoin(Member member) throws Exception {
		//네이버 간편가입
		member.setSimplejoin("1");
		//네이버 간편가입 데이터 db에 저장
		memberRepository.insert_simplejoin(member);
	}
	
	
	
	
	
}
