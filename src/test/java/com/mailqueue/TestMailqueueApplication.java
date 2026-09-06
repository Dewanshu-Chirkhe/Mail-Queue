package com.mailqueue;

import org.springframework.boot.SpringApplication;

public class TestMailqueueApplication {

	public static void main(String[] args) {
		SpringApplication.from(MailqueueApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
