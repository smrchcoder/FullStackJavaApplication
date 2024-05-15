package com.blueyonder.shopppingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ShopppingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopppingserviceApplication.class, args);
	}

}
