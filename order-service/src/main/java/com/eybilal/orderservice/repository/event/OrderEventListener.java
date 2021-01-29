package com.eybilal.orderservice.repository.event;

import com.eybilal.orderservice.model.entity.Order;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

/**
 * @author Bilal El Yousfi
 */
@Component
public class OrderEventListener extends AbstractRepositoryEventListener<Order> {
    @Override
    protected void onAfterCreate(Order order) {
        System.out.println("===============> order saved with id " + order.getId());
    }

    @Override
    protected void onAfterSave(Order order) {
        System.out.println("===> onAfterSave");
    }

    @Override
    protected void onAfterLinkSave(Order order, Object linked) {
        System.out.println("===> onAfterLinkSave");
    }
}
