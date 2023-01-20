package kr.co.sboard.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.security.MyUserDetails;
import kr.co.sboard.service.ArticleService;
import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService service;

	@GetMapping("list")
	public String list(@AuthenticationPrincipal MyUserDetails myUser, Model model, String pg) {
		
		UserEntity user = myUser.getUser();
		
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitstart(currentPage);
		long total = service.getTotalCount();
		int lastPage = service.getLastPageNum(total);
		int pageStartNum = service.getPageStartNum(total, start);
		int groups[] = service.getPageGroup(currentPage, lastPage);
		
		List<ArticleVO> articles = service.selectArticles(start);
		
		model.addAttribute("user", user);
		model.addAttribute("articles", articles);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("groups", groups);
		return "list";
		
	}
	
	@GetMapping("modify")
	public String modify() {
		return "modify";
	}
	
	@GetMapping("view")
	public String view(@RequestParam("no") int no, Model model) {
		ArticleVO art = service.selectArticle(no);
		model.addAttribute("art", art);
		return "view";
	}
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	@PostMapping("write")
	public String write(ArticleVO vo) {
		service.insertArticle(vo);
		return "redirect:/list";
	}
	
	@GetMapping("download")
	public ResponseEntity<Resource> download(int fno) throws IOException {
		FileVO vo = service.selectFile(fno);
		ResponseEntity<Resource> respEntity = service.fileDownload(vo);
		return respEntity;
	}
	
	@GetMapping("delete")
	public String delete(int no) {
		service.deleteArticle(no);
		return "redirect:/list";
	}
	
}
