package com.eybilal.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUTH-SERVICE", url = "http://localhost:8080/AUTH-SERVICE")
public interface AuthServiceClient {
    @PostMapping(value = "/login")
    IdToken login(@RequestBody UsernamePassword usernamePassword);
}
