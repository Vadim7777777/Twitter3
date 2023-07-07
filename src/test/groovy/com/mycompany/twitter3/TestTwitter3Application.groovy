package com.mycompany.twitter3

import com.mycompany.Twitter3Application
import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MongoDBContainer

@TestConfiguration(proxyBeanMethods = false)
class TestTwitter3Application {

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		new MongoDBContainer("mongo:latest")
	}

	static void main(String[] args) {
		SpringApplication.from(Twitter3Application::main).with(TestTwitter3Application).run(args)
	}

}
