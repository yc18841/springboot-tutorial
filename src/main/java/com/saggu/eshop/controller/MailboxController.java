package com.saggu.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

public class MailboxController {
	@Autowired private RestTemplate restTemplate;
	
	@GetMapping(value = "/remove-mailbox/{mid}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> removeMailbox(@PathVariable String mid) {
		restTemplate.exchange("https://openlibrary.org/api/books?bibkeys=ISBN:{mid},LCCN:93005405&format=json", HttpMethod.GET, new HttpEntity<Object>(getHeaders()), String.class, mid);
		return null;
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		
		return headers;
	}

}
