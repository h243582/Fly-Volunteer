package com.hyf.ribbon.cntroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/ribbon/getPort")
    public Integer getPort() {
        return port;
    }



    @GetMapping("/demo/{id}")
    public String findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://hyf-demo/demo/" + id, String.class);
    }

    @GetMapping("/demo")
    public String findById1() {
        return this.restTemplate.getForObject("http://hyf-demo/demo/" , String.class);
    }


    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("hyf-demo");
        // 打印当前选择的是哪个节点
        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}