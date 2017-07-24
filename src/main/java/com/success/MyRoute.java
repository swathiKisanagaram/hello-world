package com.success;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder{

	@Autowired
	private MyProcessor myProcessor;
	
	@Autowired
	private AccountProcessor accountProcessor;
	
	@Override
	public void configure() throws Exception {
		 from("direct:firstRoute")
		  .log("Camel body: ${body}")
		  .process(myProcessor)
		  .to("direct:SecondRoute");
		 
		 from("direct:AccountfirstRoute")
		  .log("Camel body: ${body}")
		  .process(accountProcessor)
		  .to("direct:SecondRoute");
		 
		 from("direct:SecondRoute")
		  .log("Secound Route Camel body: ${body}");
		 
		 }		
	
	/*
	 * http://camel.apache.org/kafka
	 * 
	 *  @Bean(name = "KafkaRouteProducer")
    public RouteBuilder kafkaRouteProducer() {
        return new RouteBuilder() {
            public void configure() {
                from("direct:kafkaRoute").to("kafka:localhost:9092?topic=test&zookeeperHost=localhost&zookeeperPort=2181&groupId=group1&serializerClass=kafka.serializer.StringEncoder").bean(kafkaOutputBean.class);
            }
        };
    }
 
    @Bean(name="KafkaRouteConsumer")
    public RouteBuilder kafkaRouteConsumer() {
        return new RouteBuilder() {
            public void configure() {
                from("kafka:localhost:9092?topic=test&zookeeperHost=localhost&zookeeperPort=2181&groupId=group1&serializerClass=kafka.serializer.StringEncoder").bean(kafkaOutputBean.class);
            }
        };
    }
 
    public static class kafkaOutputBean {
        public void printKafkaBody(String body) {
            System.out.println("KafkaBody result >>>>> " + body);
        }
    }
    */

}
