package com.pthienquan1.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by quan0
 * Date 6/12/2023 - 6:55 PM
 * Description: ...
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
    public static void main(String[] args){
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
