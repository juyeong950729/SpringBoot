package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.repository.User1Repo;
import kr.co.ch07.vo.User1VO;

@Controller
public class MainController {
	
	@Autowired
	private User1Repo repo;
	
	@GetMapping(value= {"/", "/index"})
	public String index() {
		return "/index";
	}
	
	@GetMapping("/query1")
	public String query1() {
		User1VO rs1 =repo.findUser1VOByUid("a103");
		System.out.println("query1 결과 : " + rs1);
		return "redirect:/";
	}
	
	@GetMapping("/query2")
	public String query2() {
		List<User1VO> rs2 =repo.findUser1VOByName("장보고");
		System.out.println("query2 결과 : " + rs2);
		return "redirect:/";
	}
	
	@GetMapping("/query3")
	public String query3() {
		List<User1VO> rs3 =repo.findUser1VOByNameNot("장보고");
		System.out.println("query3 결과 : " + rs3);
		return "redirect:/";
	}
	
	@GetMapping("/query4")
	public String query4() {
		User1VO rs4 =repo.findUser1VOByUidAndName("a103", "장보고");
		System.out.println("query4 결과 : " + rs4);
		return "redirect:/";
	}
	
	@GetMapping("/query5")
	public String query5() {
		List<User1VO> rs5 =repo.findUser1VOByUidOrName("a103", "강감찬");
		System.out.println("query5 결과 : " + rs5);
		return "redirect:/";
	}
	
	@GetMapping("/query6")
	public String query6() {
		List<User1VO> rs6 =repo.findUser1VOByAgeGreaterThan(43);
		System.out.println("query6 결과 : " + rs6);
		return "redirect:/";
	}
	
	@GetMapping("/query7")
	public String query7() {
		List<User1VO> rs7 =repo.findUser1VOByAgeGreaterThanEqual(43);
		System.out.println("query7 결과 : " + rs7);
		return "redirect:/";
	}
	
	@GetMapping("/query8")
	public String query8() {
		List<User1VO> rs8 =repo.findUser1VOByAgeLessThan(43);
		System.out.println("query8 결과 : " + rs8);
		return "redirect:/";
	}
	
	@GetMapping("/query9")
	public String query9() {
		List<User1VO> rs9 =repo.findUser1VOByAgeLessThanEqual(43);
		System.out.println("query9 결과 : " + rs9);
		return "redirect:/";
	}
	
	@GetMapping("/query10")
	public String query10() {
		List<User1VO> rs10 =repo.findUser1VOByNameLike("장%");
		System.out.println("query10 결과 : " + rs10);
		return "redirect:/";
	}
	
	@GetMapping("/query11")
	public String query11() {
		List<User1VO> rs11 =repo.findUser1VOByNameContains("장");
		System.out.println("query11 결과 : " + rs11);
		return "redirect:/";
	}
	
	@GetMapping("/query12")
	public String query12() {
		List<User1VO> rs12 =repo.findUser1VOByNameStartsWith("장");
		System.out.println("query12 결과 : " + rs12);
		return "redirect:/";
	}
	
	@GetMapping("/query13")
	public String query13() {
		List<User1VO> rs13 =repo.findUser1VOByNameEndsWith("신");
		System.out.println("query13 결과 : " + rs13);
		return "redirect:/";
	}
	
	@GetMapping("/query17")
	public String query17() {
		List<User1VO> rs17 =repo.findUser1VOByAgeGreaterThanOrderByAgeDesc(40);
		System.out.println("query17 결과 : " + rs17);
		return "redirect:/";
	}
	
	@GetMapping("/query18")
	public String query18() {
		int rs18 =repo.countUser1VOByUid("A101");
		System.out.println("query18 결과 : " + rs18);
		return "redirect:/";
	}
	
	@GetMapping("/query19")
	public String query19() {
		int rs19 =repo.countUser1VOByName("김유신");
		System.out.println("query19 결과 : " + rs19);
		return "redirect:/";
	}
	

}
