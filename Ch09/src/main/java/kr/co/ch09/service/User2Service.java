package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.User2DAO;
import kr.co.ch09.vo.User2VO;

@Service
public class User2Service {
	
	@Autowired
	private User2DAO dao;
	
	public int insertUser2(User2VO vo) {
		return dao.insertUser2(vo);
	}
	public User2VO selectUser2(String uid) {
		return dao.selectUser2(uid);
	}
	public List<User2VO> selectUser2s(){
		return dao.selectUser2s();
	}
	public int updateUser2(User2VO vo) {
		return dao.updateUser2(vo);
	}
	public int deleteUser2(String uid) {
		return dao.deleteUser2(uid);
	}

}
