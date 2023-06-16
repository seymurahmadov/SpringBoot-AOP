package com.example.springbootaop.repositrory;

import com.example.springbootaop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepository extends JpaRepository<ProductEntity,Long> {
}
