package com.semihtumay.cqrspattern.infrastructure.repository;

import com.semihtumay.cqrspattern.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
