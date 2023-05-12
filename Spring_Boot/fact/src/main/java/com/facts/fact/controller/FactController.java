package com.facts.fact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.facts.fact.domain.*;
import com.facts.fact.repository.*;
import com.facts.fact.service.FactService;

@Controller
public class FactController {
	
	 @Autowired
	    private FactService service;

	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<Fact> listfact = service.listAll();
	        model.addAttribute("listfact", listfact);
	        System.out.println("Get / ");
	        return "index";
	    }

	    @GetMapping("/new")
	    public String add(Model model) {
	    	System.out.println("Get /new ");
	    	Fact f = new Fact();
	        model.addAttribute("fact", f);
	        return "new";
	    }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveFact(@ModelAttribute("fact") Fact std) {
	        service.save(std);
	        return "redirect:/";
	    }

	    @RequestMapping("/edit/{id}")	
	    public ModelAndView showEditFactPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Fact std = service.get(id);
	        mav.addObject("fact", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletefact(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/";
	    }
}