package com.eybilal.inventoryservice.config;

import com.eybilal.inventoryservice.entity.Category;
import com.eybilal.inventoryservice.entity.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class SpringDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setBasePath("/api/v1")
              .exposeIdsFor(Product.class, Category.class);
    }
}
