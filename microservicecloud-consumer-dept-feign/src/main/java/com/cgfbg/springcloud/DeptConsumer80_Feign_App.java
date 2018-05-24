package com.cgfbg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.cgfbg.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.atguigu.springcloud" })
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
