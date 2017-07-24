package com.success;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Process started");
		String myString = exchange.getIn().getBody(String.class);
		myString = myString.toUpperCase()+" Converted to uppercase ";
		exchange.getIn().setBody(myString);
		System.out.println("Process Completed");
	}

}
