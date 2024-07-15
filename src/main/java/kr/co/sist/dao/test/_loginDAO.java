package kr.co.sist.dao.test;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.MemberDomain;
import kr.co.sist.vo.MemberVO;

@Component
public class _loginDAO {

	@Autowired(required = false)
	private MyBatisDAO mbDAO;
	
	public MemberDomain selectMember( MemberVO mv ) throws PersistenceException{
		
		MemberDomain member_id = null;
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		member_id = ss.selectOne("kr.co.sist.practice.searchMember", mv);
		System.out.println( mv +" / "+ member_id);
		mbDAO.closeHandler(ss);
		return member_id;
		
	}
}
