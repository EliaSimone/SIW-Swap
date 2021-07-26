package com.siw.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siw.project.model.Categoria;
import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;
import com.siw.project.persistance.DBManager;

@RestController
public class MyRestController {
	
	@PostMapping("/login")
	public String login(@RequestParam String user, @RequestParam String password, HttpServletRequest request) {
		Utente u = DBManager.getInstance().UtenteDAO().findByName(user);
		if (u==null)
			return "NO";
		if (u.getPassword().equals(password)) {
			request.getSession().setAttribute("user", u);
			return "OK";
		}
		return "NO";
	}
	
	@PostMapping("/signin")
	public String signin(@RequestParam String user, @RequestParam String password, HttpServletRequest request) {
		Utente u = DBManager.getInstance().UtenteDAO().findByName(user);
		if (u!=null)
			return "NO";
		u = new Utente(user, null, password, null, null, null, null);
		try {
			DBManager.getInstance().UtenteDAO().save(u);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		request.getSession().setAttribute("user", u);
		return "OK";
	}
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
		return "OK";
	}
	
	@PostMapping("/buy")
	public String buy(@RequestParam int productid, HttpServletRequest request) {
		Prodotto prod=DBManager.getInstance().prodottoDAO().findById(productid);
		Utente buyer = (Utente) request.getSession().getAttribute("user");
		if (buyer==null)
			return "NO";
		prod.setCompratore(buyer);
		try {
			DBManager.getInstance().prodottoDAO().update(prod);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		return "OK";
	}
	
	@PostMapping("/saveprofile")
	public String saveprofile(@RequestParam String cognome, @RequestParam String citta, @RequestParam String indirizzo, @RequestParam String tel, @RequestParam String descrizione, HttpServletRequest request) {
		Utente user = (Utente) request.getSession().getAttribute("user");
		if (user==null)
			return "NO";
		user.setCognome(cognome);
		user.setCitta(citta);
		user.setIndirizzo(indirizzo);
		user.setTel(tel);
		user.setDescrizione(descrizione);
		try {
			DBManager.getInstance().UtenteDAO().update(user);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		return "OK";
	}
	
	@PostMapping("/addproduct")
	public String addproduct(@RequestParam String nome, @RequestParam double prezzo, @RequestParam String categoria, @RequestParam String descrizione, HttpServletRequest request) {
		Utente seller = (Utente) request.getSession().getAttribute("user");
		if (seller==null)
			return "NO";
		Prodotto prodotto=new Prodotto(-1, nome, prezzo, descrizione, new Categoria(categoria), seller, null);
		try {
			DBManager.getInstance().prodottoDAO().save(prodotto);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		return "OK";
	}
	
	@PostMapping("/saveproduct")
	public String saveproduct(@RequestParam int id, @RequestParam String nome, @RequestParam double prezzo, @RequestParam String categoria, @RequestParam String descrizione, HttpServletRequest request) {
		Utente seller = (Utente) request.getSession().getAttribute("user");
		if (seller==null)
			return "NO";
		Prodotto prodotto=new Prodotto(id, nome, prezzo, descrizione, new Categoria(categoria), seller, null);
		try {
			DBManager.getInstance().prodottoDAO().update(prodotto);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		return "OK";
	}
	
	@PostMapping("/deleteproduct")
	public String saveproduct(@RequestParam int id, HttpServletRequest request) {
		Utente seller = (Utente) request.getSession().getAttribute("user");
		if (seller==null)
			return "NO";
		Prodotto prodotto=new Prodotto();
		prodotto.setIdentifier(id);
		try {
			DBManager.getInstance().prodottoDAO().delete(prodotto);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		return "OK";
	}
	
	@GetMapping("/ciao")
	public Utente ciao(@RequestParam Utente u) {
		return DBManager.getInstance().UtenteDAO().findByName(u.getNome());
	}

}
