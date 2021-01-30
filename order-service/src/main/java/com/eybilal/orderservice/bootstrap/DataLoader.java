package com.eybilal.orderservice.bootstrap;

import com.eybilal.orderservice.client.*;
import com.eybilal.orderservice.model.entity.Order;
import com.eybilal.orderservice.model.entity.OrderItem;
import com.eybilal.orderservice.repository.OrderItemRepository;
import com.eybilal.orderservice.repository.OrderRepository;
import com.eybilal.orderservice.utils.JWTConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerServiceClient customerServiceClient;
    private final InventoryServiceClient inventoryServiceClient;
    private final AuthServiceClient authServiceClient;

    @Override
    public void run(String... args) throws Exception {
        UsernamePassword usernamePassword = UsernamePassword.builder()
                                                            .username("user1")
                                                            .password("user1.")
                                                            .build();

        final IdToken idToken = authServiceClient.login(usernamePassword);
        final String authorization = JWTConstants.TOKEN_PREFIX + idToken.getAccessToken();

        final Customer customer1 = customerServiceClient.findUserById(
                authorization,
                1L
        );

        final Order CreatedOrder1 = orderRepository.save(
            Order.builder()
                 .orderNumber("2021-01-19/0000000001")
                 .customerId(customer1.getId())
                 .build()
        );

        final Order createdOrder2 = orderRepository.save(
            Order.builder()
                 .orderNumber("2021-01-19/0000000002")
                 .customerId(customer1.getId())
                 .build()
        );

        inventoryServiceClient.findAllProducts(authorization).getContent().forEach(product -> {
            orderItemRepository.save(
                    OrderItem.builder()
                                    .productId(product.getId())
                                    .order(CreatedOrder1)
                                    .quantity(1)
                                    .build()
            );

            orderItemRepository.save(
                    OrderItem.builder()
                            .productId(product.getId())
                            .order(createdOrder2)
                            .quantity(2)
                            .build()
            );
        });
    }
}
