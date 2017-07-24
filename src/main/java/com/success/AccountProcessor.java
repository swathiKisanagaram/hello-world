package com.success;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class AccountProcessor implements Processor {


		public void process(Exchange exchange) throws Exception {
			System.out.println("Account Process started");
			Account account = exchange.getIn().getBody(Account.class);
			account.setCount(2);
			account.setRouteName("First Account Route");
			exchange.getIn().setBody(account);
			System.out.println("Account Process Completed");
		}
		
	

}
