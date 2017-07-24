package com.success;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	 ProducerTemplate producerTemplate;
	
	 @RequestMapping(value = "/test")
	 public void startCamel() {
	  producerTemplate.sendBody("direct:firstRoute", "Calling via Spring Boot Rest Controller");
	 }
	
	 @RequestMapping(value = "/testWithBoject")
	 public void startCamelWithObject() {
	  Account account = new Account();
	  account.setCount(1);
	  account.setRouteName("In Controller");
	  producerTemplate.sendBody("direct:AccountfirstRoute", account);
	 }
	
}
