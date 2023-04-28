package kr.co.ch09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.User2VO;

@Mapper
@Repository
public interface User2DAO {
	
	public int insertUser2(User2VO vo);
	public User2VO selectUser2(String uid);
	public List<User2VO> selectUser2s();
	public int updateUser2(User2VO vo);
	public int deleteUser2(String uid);

}
