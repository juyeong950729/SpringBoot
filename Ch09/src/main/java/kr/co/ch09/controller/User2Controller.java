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

import kr.co.ch09.service.User2Service;
import kr.co.ch09.vo.User2VO;

@Controller
public class User2Controller {

	@Autowired
	private User2Service service;
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@GetMapping("/user2s")
	public List<User2VO> list1() {
		List<User2VO> users = service.selectUser2s();
		return users;
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@GetMapping("/user2")
	public User2VO list2(String uid) {
		return service.selectUser2(uid);
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@GetMapping("/user2/{id}")
	public User2VO list3(@PathVariable("id") String uid) {
		return service.selectUser2(uid);
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@PostMapping("/user2")
	public Map<String, Integer> register(@RequestBody User2VO vo) {
		int result = service.insertUser2(vo);
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@PutMapping("/user2")
	public List<User2VO> modify(@RequestBody User2VO vo) {
		
		int result = service.updateUser2(vo);
		//List<User1VO> users = service.selectUser1s();
		
		//Map<String, Integer> resultMap = new HashMap<>();
		//resultMap.put("result", 1);
		return service.selectUser2s();
	}
	
	@ResponseBody
	@CrossOrigin(origins="*")
	@DeleteMapping("/user2/{id}")
	public List<User2VO> delete(@PathVariable("id") String uid) {
		service.deleteUser2(uid);
		//Map<String, Integer> resultMap = new HashMap<>();
		//resultMap.put("result", 1);
		return service.selectUser2s();
	}
}
