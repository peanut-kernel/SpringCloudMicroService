package com.cgfbg.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	//@Bean
	public IRule myRule() {
		// return new RoundRobinRule();
		// return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
		return new RoundRobinRule();
	}

	//@Bean
	public LoadBalancerClient loadBalancerClient(SpringClientFactory factory) {
		return new RibbonLoadBalancerClient(factory) {
			@Override
			protected Server getServer(String serviceId) {
				return new Server("127.0.0.1", 8001);
			}
		};
	}
}

// @Bean
// public UserServcie getUserServcie()
// {
// return new UserServcieImpl();
// }
// applicationContext.xml == ConfigBean(@Configuration)
// <bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">