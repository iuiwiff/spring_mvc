package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.domain.MemberDomain;
import kr.co.sist.service._loginService;
import kr.co.sist.vo.MemberVO;

@Controller
public class _loginController {

	@Autowired(required = false)
	private _loginService ls;
	
	@GetMapping("/day0613/login.do")
	public String searchMember( MemberVO mv, Model model) {
		MemberDomain md = ls.searchMember(mv);
		
		model.addAttribute("member", md);
		
		return "day0613/_login_result";
	}
}
