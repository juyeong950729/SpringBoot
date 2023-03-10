package kr.co.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.bookstore.service.CustomerService;
import kr.co.bookstore.vo.CustomerVO;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<CustomerVO> custs = service.selectCustomers();
		model.addAttribute("custs", custs);
		return "/customer/list";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/customer/register";
	}
	
	@PostMapping("/register")
	public String register(CustomerVO vo) {
		service.insertCustomer(vo);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/modify")
	public String modify(int custId, Model model) {
		CustomerVO cust = service.selectCustomer(custId);
		model.addAttribute("cust", cust);
		return "/customer/modify";
	}
	
	@PostMapping("/modify")
	public String modify(CustomerVO vo) {
		service.updateCustomer(vo);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String delete(int custId) {
		service.deleteCustomer(custId);
		return "redirect:/customer/list";
	}

}
