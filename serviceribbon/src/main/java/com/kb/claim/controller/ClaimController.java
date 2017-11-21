package com.kb.claim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kb.claim.service.ClaimService;

@RestController
public class ClaimController {

	@Autowired
	ClaimService claimService;

	@RequestMapping(value = "/claims/{id}", method = { RequestMethod.GET})
	public String getClaim(@PathVariable("id") String id) {
		return claimService.getClaim(id);
	}
}
