package com.siw.project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siw.project.model.Categoria;
import com.siw.project.model.Commento;
import com.siw.project.model.Messaggio;
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
	
	@PostMapping("/mex")
	public String mex(@RequestParam String from, @RequestParam String to, @RequestParam String text, HttpServletRequest request) {
		Utente seller = (Utente) request.getSession().getAttribute("user");
		if (seller==null)
			return "NO";
		Utente sender = DBManager.getInstance().UtenteDAO().findByName(from);
		Utente dest = DBManager.getInstance().UtenteDAO().findByName(to);
		Messaggio messaggio=new Messaggio(-1, sender, dest, text, new Date(System.currentTimeMillis()));
		try {
			DBManager.getInstance().MessaggioDAO().save(messaggio);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		return "OK";
	}
	
	@PostMapping("/comment")
	public String comment(@RequestParam int productid, @RequestParam String text, HttpServletRequest request) {
		Utente user = (Utente) request.getSession().getAttribute("user");
		if (user==null)
			return "NO";
		
		Prodotto p=DBManager.getInstance().prodottoDAO().findById(productid);		
		Commento commento = new Commento(productid, text, user, p);
		try {
			DBManager.getInstance().CommentoDAO().save(commento);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "NO";
		}
		return "OK";
	}
	
	@PostMapping("/getcomments")
	public List<Commento> getcomments(@RequestParam int productid, HttpServletRequest request, HttpServletResponse response) {
		Utente user = (Utente) request.getSession().getAttribute("user");
		if (user==null) {
			try {
				response.sendError(403);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Prodotto p = DBManager.getInstance().prodottoDAO().findById(productid);
		return DBManager.getInstance().CommentoDAO().findByProduct(p);
	}
	
	@GetMapping("/ciao")
	public List<Messaggio> ciao(@RequestParam String username) {
		Utente u = DBManager.getInstance().UtenteDAO().findByName(username);
		return DBManager.getInstance().MessaggioDAO().findByDest(u);
	}

}
