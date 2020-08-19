package com.cgfbg.springcloud;

import com.cgfbg.myrule.MySelfRule;
import com.cgfbg.springcloud.cfgbeans.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
// 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name="testservice1", configuration = MySelfRule.class)
@RibbonClients( value = {
		@RibbonClient(name = "testservice1", configuration = MySelfRule.class),
		@RibbonClient(name = "testservice2", configuration = MySelfRule.class)
}
)
public class DeptConsumerRestTemplate8888_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerRestTemplate8888_App.class, args);
	}
}
