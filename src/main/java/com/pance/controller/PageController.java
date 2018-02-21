package com.pance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Controller
public class PageController {
	
	@RequestMapping("/hello")
	 public String index ()
	 {
		return "hello";
	 }
	
	@RequestMapping(value = {"/greeting","/greeting/{name}"})
	public String greeting(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());	
		}else {
			model.addAttribute("name", "apap");
		}
		
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value = "a", required = false, defaultValue = "0") String a, 
							@RequestParam(value = "b", required = false, defaultValue = "0") String b,
							Model model) {
		int hasilPerkalian = Integer.parseInt(a)*Integer.parseInt(b);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", hasilPerkalian);
		
		return "perkalian";
	}
	
}
