package kr.co.ch09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.User3VO;

@Mapper
@Repository
public interface User3DAO {
	
	public int insertUser3(User3VO vo);
	public User3VO selectUser3(String uid);
	public List<User3VO> selectUser3s();
	public int updateUser3(User3VO vo);
	public int deleteUser3(String uid);

}
