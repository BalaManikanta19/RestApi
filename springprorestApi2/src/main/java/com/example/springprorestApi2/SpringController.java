package com.example.springprorestApi2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class SpringController {

	Map<String,RestUser> Allusers=new HashMap<>();
	
	@GetMapping
	public Collection<RestUser> getmethod(){
		return Allusers.values();
	}
	
	@PostMapping
	public String postmethod(@RequestBody RestUser userdetails) {
		RestUser addvalue=new RestUser();
		
		addvalue.setId(userdetails.getId());
		addvalue.setName(userdetails.getName());
		addvalue.setMail(userdetails.getMail());
		Allusers.put(userdetails.getId(), addvalue);
		return "user adddeed successfully ";
		
	}
	
	
	@PutMapping(path = "/{id}")
	public String putMethod(@PathVariable String id,@RequestBody RestUser userdetails) {
		if(Allusers.containsKey(id)) {
			RestUser addvalue=new RestUser();
			addvalue.setId(userdetails.getId());
			addvalue.setName(userdetails.getName());
			addvalue.setMail(userdetails.getMail());
			Allusers.put(id, addvalue);
			return "edit is done" ;
			}
		else {
			return "userId not found";
		}
	}
	@DeleteMapping(path="/{id}")
	public String deletemethod(@PathVariable String id) {
		if(Allusers.containsKey(id)) {
			Allusers.remove(id);
			
		}
		else {
			return "user not found";
		
		}
		return "user deleted succefully";
	}}
