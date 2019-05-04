package com.dharbor.workflow;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sudeendrag
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WorkFlowServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkFlowServiceApplication.class, args);
	}
}
