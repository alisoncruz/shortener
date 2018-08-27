package br.com.projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.entity.Url;
import br.com.projeto.service.UrlService;

@RestController
public class UrlController {

	UrlService uService = new UrlService();

//	create url
	@RequestMapping(value = "/url", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<Url> ProcessUser(@RequestBody Url url) {

		try {
			uService.create(url);

			return uService.getList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		}
		

	}

//list urls
	@RequestMapping(value = "/listUrls", method = RequestMethod.GET, produces = "application/json")
	public List<Url> listUrls() {
		try {
			return uService.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/deleteuser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public List<Url> DeleteUser(@RequestBody Url url) {

		try {
			uService.delete(url.getIdUrl());
			return uService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/updateUrl", method = RequestMethod.PUT)
	public List<Url> updateUrl(@RequestBody Url url) {
		
		try {
			uService.update(url);
			return uService.getList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
