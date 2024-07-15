package kr.co.sist.service;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.dao.test._loginDAO;
import kr.co.sist.domain.MemberDomain;
import kr.co.sist.vo.MemberVO;

@Service
public class _loginService {
	
	
	@Autowired(required = false)
	private _loginDAO lDAO;
	
	public MemberDomain searchMember( MemberVO mv ) {
		MemberDomain member_id = null;
		
		try {
		member_id = lDAO.selectMember(mv);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return member_id;
	}

}
