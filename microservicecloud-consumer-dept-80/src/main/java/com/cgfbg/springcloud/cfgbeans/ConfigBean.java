package com.cgfbg.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean // boot -->spring applicationContext.xml --- @Configuration配置 ConfigBean =
						// applicationContext.xml
{
	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
	/**
	 * LoadBalancerAutoConfiguration要想生效类路径必须有RestTemplate，以及Spring容器内必须有LoadBalancerClient的实现Bean
	 * 1. LoadBalancerClient的唯一实现类是：org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient
	 * LoadBalancerInterceptor是个ClientHttpRequestInterceptor客户端请求拦截器。它的作用是在客户端发起请求之前拦截，进而实现客户端的负载均衡
	 * restTemplateCustomizer()返回的匿名定制器RestTemplateCustomizer它用来给所有的RestTemplate加上负载均衡拦截器（需要注意它的@ConditionalOnMissingBean注解~）
	 * 不难发现，负载均衡实现的核心就是一个拦截器，就是这个拦截器让一个普通的RestTemplate逆袭成为了一个具有负载均衡功能的请求器
	 */
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	//@Bean
	public IRule myRule() {
		// return new RoundRobinRule();
		// return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
		return new RetryRule();
	}
}

// @Bean
// public UserServcie getUserServcie()
// {
// return new UserServcieImpl();
// }
// applicationContext.xml == ConfigBean(@Configuration)
// <bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">