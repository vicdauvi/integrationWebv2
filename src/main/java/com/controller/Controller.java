package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.VilleDAO;
import com.model.Ville;

@RestController
public class Controller {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam(required = false, value = "value") String value) {
		System.out.println("Appel Get");
		System.out.println("value : " + value);

		return value;
	}

	@RequestMapping(value = "/listervilles", method = RequestMethod.GET)
	@ResponseBody
	public String listerVilles() {
		String villes = null ;
		System.out.println("Appel Get");
		for(Ville ville : VilleDAO.trouverVilles()) {
			villes = villes+ville.toString() ;
		}
		return villes;
	}
	
	@RequestMapping(value = "/voirVille", method = RequestMethod.GET)
	@ResponseBody
	public String listerVille(@RequestParam(required = false, value = "nomVille") String nomVille) {
		String villes = null ;
		System.out.println("Appel Get");
		return VilleDAO.trouverVille(nomVille).toString();
	}
	
	/*@RequestMapping(value = "/ajouterville", method = RequestMethod.POST)
	@ResponseBody
	public void ajouterville(Ville ville) {
		System.out.println("Appel Post");
		VilleDAO.ajouterVille(ville) ;
	}*/
}
