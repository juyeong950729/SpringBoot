package kr.co.farmstory.controller;

import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.security.MyUserDetails;
import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private ArticleService service;

    @GetMapping("board/list")
    public String list(@AuthenticationPrincipal MyUserDetails myUser, @RequestParam("cate")String cate, Model model, String group, String pg) {

        UserEntity user = myUser.getUser();

        int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitstart(currentPage);
        long total = service.getTotalCount(cate);
        int lastPage = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPage);

        List<ArticleVO> articles = service.selectArticles(start, cate);

        model.addAttribute("user", user);
        model.addAttribute("articles", articles);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);

        return "board/list";
    }

    @GetMapping("board/view")
    public String view(@RequestParam("no") int no, Model model, String group, String cate, String pg) {
        ArticleVO art = service.selectArticle(no);
        model.addAttribute("art", art);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("pg", pg);
        return "board/view";
    }

    @GetMapping("board/modify")
    public String modify(Model model, String group, String cate, String pg) {
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("pg", pg);
        return "board/modify";
    }

    @GetMapping("board/write")
    public String write(Model model, String group, String cate, String pg){
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("pg", pg);
        return "board/write";
    }

    @PostMapping("board/write")
    public String write(RedirectAttributes red, ArticleVO vo, String group, String cate, String pg){
        service.insertArticle(vo);
        red.addAttribute("group", group);
        red.addAttribute("cate", cate);
        red.addAttribute("pg", pg);
        return "redirect:/board/list";
    }

    @GetMapping("board/download")
    public ResponseEntity<Resource> download(int fno) throws IOException {
        FileVO vo = service.selectFile(fno);
        ResponseEntity<Resource> respEntity = service.fileDownload(vo);
        return respEntity;
    }

    @GetMapping("board/delete")
    public String delete(int no, RedirectAttributes red, String group, String cate, String pg){
        service.deleteArticle(no);
        red.addAttribute("group", group);
        red.addAttribute("cate", cate);
        red.addAttribute("pg", pg);
        return "redirect:/board/list";
    }

}
