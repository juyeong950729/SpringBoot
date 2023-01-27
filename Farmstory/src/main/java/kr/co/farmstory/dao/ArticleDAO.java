package kr.co.farmstory.dao;

import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleDAO {
    public int insertArticle(ArticleVO vo);
    public int selectCountTotal(String cate);
    public ArticleVO selectArticle(int no);
    public List<ArticleVO> selectArticles(@Param("start") int start, @Param("cate") String cate);
    public int updateArticle(ArticleVO vo);
    public int updateArticleHit(int no);
    public int deleteArticle(int no);

    public int insertFile(FileVO vo);
    public FileVO selectFile(int fno);
    public int updateDownload(int fno);
}
