package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.User3DAO;
import kr.co.ch09.vo.User3VO;

@Service
public class User3Service {
	
	@Autowired
	private User3DAO dao;
	
	public int insertUser3(User3VO vo) {
		return dao.insertUser3(vo);
	}
	public User3VO selectUser3(String uid) {
		return dao.selectUser3(uid);
	}
	public List<User3VO> selectUser3s(){
		return dao.selectUser3s();
	}
	public int updateUser3(User3VO vo) {
		return dao.updateUser3(vo);
	}
	public int deleteUser3(String uid) {
		return dao.deleteUser3(uid);
	}

}
