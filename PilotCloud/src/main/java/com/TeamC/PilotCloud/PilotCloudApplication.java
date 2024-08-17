package com.TeamC.PilotCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class PilotCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilotCloudApplication.class, args);
	}

}
