package kr.co.sist.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.vo.loginVO;

@Controller
public class SecurityController {
	
	@PostMapping("/day0614/login_process.do")
	public String loginProcess(loginVO lv, Model model) {
		
		//서비스를 사용하여 입력된 아이디와 비밀번호를 쿼리문에 넣어 실행하게 된다.
		PasswordEncoder pe = new BCryptPasswordEncoder();
		
		//2. 암호화
		String dbPass = "test1234";
		String cipherPass = pe.encode(dbPass); //회원 가입시 insert
		
		boolean loginFlag = pe.matches(lv.getPass(), cipherPass);
		model.addAttribute("loginResult", loginFlag);
		
		return "day0614/login_result";
	}//loginProcess
	   
	@GetMapping("/day0614/plain_text1.do")
//	@RequestMapping(value="/day0614/plain_text1.do",method = RequestMethod.GET)
	public String searchUser(Model model) {
		//DBMS에서 조회된 결과
		String name="7f45e29511b81b8122d02e0e0c0955dbf09b1b7ba8e9e92c0cd6e195740543b2";
		String email="912e147026882e101ddff2606dbf31a7f607455f1686b7bba3295989fb97e790";
		
		String key = "test1234";
		String salt = "123456";
		
		//1. 암호화 객체 생성
		TextEncryptor te = Encryptors.text(key, salt);
		
		//2. 복호화
		model.addAttribute("name", te.decrypt(name));
		model.addAttribute("email", te.decrypt(email));
		
		return "day0614/plain_text";
	
	}
	
	
	
	public static void main(String[] args) {
		
//		//1. 암호화 객체 생성
		PasswordEncoder pe = new BCryptPasswordEncoder(); //passwordEncoder의 자식이 BCryptPasswordEncoder
		
		//2. 암호화
		String plainPass = "a1234";
		String cypherPass = pe.encode(plainPass); //회원 가입시 insert
		System.out.println("평문 비번 : " + plainPass);
		System.out.println("암호화 비번 : " + cypherPass);
		
		//3.비교
		String inputPass = "test1234";
		String cypherPass2 = pe.encode(inputPass);
		System.out.println("암호화 비번 : " + cypherPass2);
		boolean flag = pe.matches(inputPass, cypherPass2);
		System.out.println(flag);
		
		//암호화, 복호화
//		String name = "이명화";
//		String email = "lee@test.com";
//		
//		String key = "test1234";
//		String salt = "123456";
//		
//		//1. 암호화 객체 생성
//		TextEncryptor te = Encryptors.text(key, salt);
//		
//		//2. 암호화 ( DB에 insert )
//		String cipherName = te.encrypt(name);
//		String cipherEmail = te.encrypt(email);
//		System.out.println("암호화 : " + cipherName);
//		System.out.println("암호화 이메일 : " + cipherEmail);
//		
//		//3. 복호화 ( 사용자에게 보여질 때 )
//		String pName = te.decrypt(cipherName);
//		String pEmail = te.decrypt(cipherEmail);
//		System.out.println("복호화 이름 : " + pName);
//		System.out.println("복호화 이메일 : " + pEmail);
		
	}//main
	
}//class
