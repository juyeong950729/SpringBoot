package kr.co.bookstore.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bookstore.vo.BookVO;

@Repository
public class BookDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBook(BookVO vo) {
		mybatis.insert("store.book.insertBook", vo);
	}
	
	public BookVO selectBook(int bookId) {
		return mybatis.selectOne("store.book.selectBook", bookId);
	}
	
	public List<BookVO> selectBooks() {
		return mybatis.selectList("store.book.selectBooks");
	}
	
	public void updateBook(BookVO vo) {
		mybatis.update("store.book.updateBook", vo);
	}
	
	public void deleteBook(int bookId) {
		mybatis.delete("store.book.deleteBook", bookId);
	}

}
