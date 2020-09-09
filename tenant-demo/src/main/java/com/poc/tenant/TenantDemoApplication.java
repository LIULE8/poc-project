package com.poc.tenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.leo.model.*"
})
public class TenantDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenantDemoApplication.class, args);
    }
}
