package com.contacts;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ContactController {

	private ContactRepository contactRepo;

	@Autowired
	public ContactController(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void home(Map<String,Object> model, HttpServletResponse response) {
		List<Contact> contacts = contactRepo.findAll();
		model.put("contacts", contacts);
		try {
			response.sendRedirect("http://contacts123.cfapps.io/contact");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return "http://contacts123.cfapps.io/";
	}

	@RequestMapping(value = "contact", method = RequestMethod.POST)
	public void submit(Contact contact, HttpServletResponse response) {
		contactRepo.save(contact);
		//return "redirect:/";
		try {
			response.sendRedirect("http://contacts123.cfapps.io/contact");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}