package com.siw.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siw.project.model.Prodotto;
import com.siw.project.persistance.DBManager;

@Controller
public class MainController {
	@GetMapping("/")
	public String ciao(Model model, HttpServletRequest request) {
		List<Prodotto> l = DBManager.getInstance().prodottoDAO().findAll();
		model.addAttribute("products", l);
		if (request.getSession().getAttribute("user")!=null)
			return "Home";
		return "HomeGuest";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam String q, Model model, HttpServletRequest request) {
		List<Prodotto> l = DBManager.getInstance().prodottoDAO().searchProduct(q);
		model.addAttribute("results", l);
		
		if (request.getSession().getAttribute("user")!=null)
			return "Result";
		return "ResultGuest";
	}
	
	@GetMapping("/profile")
	public String profile(HttpServletRequest request) {
		if (request.getSession().getAttribute("user")!=null)
			return "Profile";
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpServletRequest request) {
		if (request.getSession().getAttribute("user")!=null)
			return "Dashboard";
		return "redirect:/";
	}
	
	@GetMapping("/prodotto")
	public String prodotto(@RequestParam int id, Model model, HttpServletRequest request) {
		model.addAttribute("product", DBManager.getInstance().prodottoDAO().findById(id));
		if (request.getSession().getAttribute("user")!=null)
			return "Prodotto";
		return "redirect:/";
	}
	
	@GetMapping("/prodotto/aggiungi")
	public String addProduct(HttpServletRequest request) {
		if (request.getSession().getAttribute("user")!=null)
			return "AggiungiProdotto";
		return "redirect:/";
	}
	
	@GetMapping("/prodotto/modifica")
	public String editProduct(@RequestParam int id, Model model, HttpServletRequest request) {
		model.addAttribute("product", DBManager.getInstance().prodottoDAO().findById(id));
		if (request.getSession().getAttribute("user")!=null)
			return "ModificaProdotto";
		return "redirect:/";
	}

}
