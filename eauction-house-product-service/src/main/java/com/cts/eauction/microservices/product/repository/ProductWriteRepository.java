package com.cts.eauction.microservices.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.eauction.microservices.product.model.ProductCommand;

public interface ProductWriteRepository extends JpaRepository<ProductCommand, Integer> {

}
