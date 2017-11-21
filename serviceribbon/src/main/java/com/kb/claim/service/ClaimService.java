package com.kb.claim.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClaimService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "claimError")
    public String getClaim(String id) {
        return restTemplate.getForObject("http://service-claim/claims/{id}",String.class,id);
    }
    
    public String claimError(String id) {
    	Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("message", "claim,"+id+",sorry,error!");
		return result.toString();
		
    }

}
