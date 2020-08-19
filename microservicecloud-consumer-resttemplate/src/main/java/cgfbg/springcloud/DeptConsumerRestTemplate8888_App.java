package cgfbg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
// 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
@RibbonClient(name="MICROSERVICECLOUD-DEPT")
public class DeptConsumerRestTemplate8888_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerRestTemplate8888_App.class, args);
	}
}
