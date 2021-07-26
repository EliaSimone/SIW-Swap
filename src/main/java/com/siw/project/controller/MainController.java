package com.siw.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siw.project.model.Messaggio;
import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;
import com.siw.project.persistance.DBManager;

import ch.qos.logback.core.net.SyslogOutputStream;

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
	public String profile(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user")!=null)
			return "Profile";
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpServletRequest request, Model model) {
		Utente user = (Utente) request.getSession().getAttribute("user");
		if (user!=null) {
			List<Messaggio> mexs = DBManager.getInstance().MessaggioDAO().findByDest(user);
			List<Prodotto> prods = DBManager.getInstance().prodottoDAO().getPerSeller(user);
			List<Prodotto> sales = DBManager.getInstance().prodottoDAO().getSoldBySeller(user);
			List<Prodotto> buys = DBManager.getInstance().prodottoDAO().getPerBuyer(user);
			model.addAttribute("listmex", mexs);
			model.addAttribute("listprods", prods);
			model.addAttribute("listsales", sales);
			model.addAttribute("listbuys", buys);
			model.addAttribute("nprods", prods.size());
			model.addAttribute("nsales", sales.size());
			model.addAttribute("nbuys", buys.size());
			double gain=0;
			double spent=0;
			for (Prodotto p: sales) {
				gain+=p.getPrezzo();
			}
			for (Prodotto p: buys) {
				spent+=p.getPrezzo();
			}
			model.addAttribute("ntotgain", String.format("%.2f", gain));
			model.addAttribute("ntotspent", String.format("%.2f", spent));
			return "Dashboard";
		}
		return "redirect:/";
	}
	
	@GetMapping("/prodotto")
	public String prodotto(@RequestParam int id, Model model, HttpServletRequest request) {
		Prodotto p = DBManager.getInstance().prodottoDAO().findById(id);
		model.addAttribute("product", p);
		model.addAttribute("comments", DBManager.getInstance().CommentoDAO().findByProduct(p));
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
	public String editProduct(@RequestParam int id, Model model, HttpServletRequest request, HttpServletResponse response) {
		Prodotto prod = DBManager.getInstance().prodottoDAO().findById(id);
		Utente user = (Utente) request.getSession().getAttribute("user");
		if (user==null)
			return "redirect:/";
		if (! prod.getVenditore().getNome().equals(user.getNome())) {
			response.setStatus(403);
			return "Error";
		}
		if (prod.getCompratore()!=null) {
			response.setStatus(403);
			return "Error";
		}
		model.addAttribute("product", prod);
		return "ModificaProdotto";
	}

}
