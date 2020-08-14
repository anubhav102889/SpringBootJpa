package com.anubhav.springbootjpa.controllers;

import org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anubhav.springbootjpa.models.User;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate template;
	
	@PostMapping(value = "/form",produces = MediaType.APPLICATION_JSON_VALUE)
	public String formData(@ModelAttribute User user){
		System.out.println(user.getUserName());
		return user.getUserName();
	}
	
	@GetMapping(value = "/restTemplateForm")
	public ResponseEntity<String> restteamplateEx(){
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("userName", "anubhav");
		map.add("password", "April07@");
		HttpEntity<MultiValueMap<String, String>> httpEntity=new HttpEntity<>(map,httpHeaders);
		ResponseEntity<String> responseEntity=null;
		try {
			responseEntity=template.
				exchange("http://localhost:8084/SpringBootJpa/form", HttpMethod.POST, httpEntity, 
						new ParameterizedTypeReference<String>() {
						});
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		
	}

}
