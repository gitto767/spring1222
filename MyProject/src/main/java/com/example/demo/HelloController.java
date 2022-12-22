package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired
	MemberRepository repository;
	@RequestMapping(value= "/", method=RequestMethod.GET)
	
	public String index() {
		return "index";
	}
@RequestMapping(value= "/", method=RequestMethod.POST)
	
	public String form() {
		return "index";
	}
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView signup(
			@ModelAttribute("formModel") Member member,ModelAndView mav) {
		System.out.println("error:"+member);
		mav.setViewName("signup");
		mav.addObject("msg","sample content.");
		Iterable<Member> list=repository.findAll();
		mav.addObject("datalist",list);
		return mav;
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView signup1(
			@ModelAttribute("formModel") Member member,ModelAndView mav) {
		
		mav.setViewName("signup");
		return new ModelAndView("redirect:/");
	}
}
