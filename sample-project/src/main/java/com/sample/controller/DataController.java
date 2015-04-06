package com.sample.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sample.domain.Employee;
import com.sample.services.DataService;

@Controller
public class DataController {
	
	@Autowired
	DataService dataService;

	@RequestMapping("form")
	public ModelAndView getForm(@ModelAttribute Employee employee) {
		return new ModelAndView("form");
	}
	
	@RequestMapping("register")
	public ModelAndView registerUser(@ModelAttribute Employee employee) {
		dataService.insertRow(employee);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("list")
	public ModelAndView getList() {
		List employeeList = dataService.getList();
		return new ModelAndView("list","employeeList",employeeList);
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		dataService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("edit")
	public ModelAndView editUser(@RequestParam int id,@ModelAttribute Employee employee) {
		Employee employeeObject = dataService.getRowById(id);
		return new ModelAndView("edit","employeeObject",employeeObject);
	}
	
	@RequestMapping("update")
	public ModelAndView updateUser(@ModelAttribute Employee employee) {
		dataService.updateRow(employee);
		return new ModelAndView("redirect:list");
	}
	
//	@RequestMapping("getToken")
//	public getToken() {
//		String CLIENT_ID = "495727435593-0cge3fm7dssbh3ogrfh6ih1mhon0tujv.apps.googleusercontent.com";
//		// Create a state token to prevent request forgery.
//		  // Store it in the session for later validation.
//		  String state = new BigInteger(130, new SecureRandom()).toString(32);
//		  request.session().attribute("state", state);
//		  // Read index.html into memory, and set the Client ID,
//		  // Token State, and Application Name in the HTML before serving it.
//		  return new Scanner(new File("index.html"), "UTF-8")
//		      .useDelimiter("\\A").next()
//		      .replaceAll("[{]{2}\\s*CLIENT_ID\\s*[}]{2}", CLIENT_ID)
//		      .replaceAll("[{]{2}\\s*STATE\\s*[}]{2}", state);
//		  
//		      //.replaceAll("[{]{2}\\s*APPLICATION_NAME\\s*[}]{2}",
//		      //            APPLICATION_NAME);
//
//		
//	}


}
