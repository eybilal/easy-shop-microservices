package com.eybilal.inventoryservice.repository;

import com.eybilal.inventoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
