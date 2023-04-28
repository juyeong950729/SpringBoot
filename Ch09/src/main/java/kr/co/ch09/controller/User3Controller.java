package kr.co.ch09.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ch09.service.User3Service;
import kr.co.ch09.vo.User3VO;

@Controller
public class User3Controller {

	@Autowired
	private User3Service service;
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@GetMapping("/user3s")
	public List<User3VO> list1() {
		List<User3VO> users = service.selectUser3s();
		return users;
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@GetMapping("/user3")
	public User3VO list2(String uid) {
		return service.selectUser3(uid);
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@GetMapping("/user3/{id}")
	public User3VO list3(@PathVariable("id") String uid) {
		return service.selectUser3(uid);
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@PostMapping("/user3")
	public Map<String, Integer> register(@RequestBody User3VO vo) {
		int result = service.insertUser3(vo);
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@PutMapping("/user3")
	public List<User3VO> modify(@RequestBody User3VO vo) {
		
		int result = service.updateUser3(vo);
		//List<User1VO> users = service.selectUser1s();
		
		//Map<String, Integer> resultMap = new HashMap<>();
		//resultMap.put("result", 1);
		return service.selectUser3s();
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@DeleteMapping("/user3/{id}")
	public List<User3VO> delete(@PathVariable("id") String uid) {
		service.deleteUser3(uid);
		//Map<String, Integer> resultMap = new HashMap<>();
		//resultMap.put("result", 1);
		return service.selectUser3s();
	}
}
