package com.eybilal.inventoryservice.entity;

import com.eybilal.inventoryservice.pojo.DescriptiveEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Category extends DescriptiveEntity {
    @OneToMany(
            mappedBy="category",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Collection<Product> products;

}
