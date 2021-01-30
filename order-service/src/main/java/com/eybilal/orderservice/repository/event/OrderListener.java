package com.eybilal.orderservice.repository.event;

import com.eybilal.orderservice.model.entity.Order;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Bilal El Yousfi
 */
@Component
public class OrderListener {
    @PrePersist
    private void onBeforeCreate(Order order) {
        System.out.println("===========> onBeforeCreate");
    }

    @PostPersist
    private void onAfterCreate(Order order) {
        System.out.println("===============> order saved with id " + order.getId());
    }

    @PreUpdate
    private void onBeforeUpdate(Order order) {
        System.out.println("===> onBeforeUpdate");
    }

    @PostUpdate
    private void onAfterUpdate(Order order) {
        System.out.println("===> onAfterUpdate");
    }
}
