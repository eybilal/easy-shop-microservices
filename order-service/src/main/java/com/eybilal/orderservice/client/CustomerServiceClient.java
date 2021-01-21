package com.eybilal.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "CUSTOMER-SERVICE", url = "http://localhost:8080/CUSTOMER-SERVICE")
public interface CustomerServiceClient {
    @GetMapping(value = "/api/v1/customers/{id}")
    Customer findUserById(@RequestHeader("Authorization") String authorization, @PathVariable(name = "id") Long id);
}
