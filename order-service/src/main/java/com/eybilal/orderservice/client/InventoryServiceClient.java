package com.eybilal.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "INVENTORY-SERVICE", url = "http://localhost:8080/INVENTORY-SERVICE")
public interface InventoryServiceClient {
    @GetMapping(value = "/api/v1/products/{id}")
    Product findProductById(@PathVariable(name = "id") Long id);

    @GetMapping(value = "/api/v1/products")
    PagedModel<Product> findAllProducts(@RequestHeader("Authorization") String authorization);
}
