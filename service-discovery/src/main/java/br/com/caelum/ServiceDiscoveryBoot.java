package br.com.caelum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryBoot {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryBoot.class, args);
    }
}
