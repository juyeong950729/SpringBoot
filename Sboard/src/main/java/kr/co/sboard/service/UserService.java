package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.repository.UserRepo;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;

	public int insertUser(UserVO vo) {
		vo.setPass(encoder.encode(vo.getPass1()));
		return dao.insertUser(vo);
	}
	public UserVO selectUser(String uid) {
		return dao.selectUser(uid);
	}
	public List<UserVO> selectUsers(){
		return dao.selectUsers();
	}
	public int updateUser(UserVO vo) {
		return dao.updateUser(vo);
	}
	public int deleteUser(String uid) {
		return dao.deleteUser(uid);
	}
	public int countByUid(String uid) {
		return repo.countByUid(uid);
	}
	
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
}
