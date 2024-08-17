package com.TeamC.PilotServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class PilotServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilotServerApplication.class, args);
	}

}
