package com.ESEO_API_REST.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	@RequestMapping(value="/test", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam(required = false, value="value")String value) {
		System.out.println("Appel Get");
		System.out.println("value : "+value);
		
		return value ;
	}
}
