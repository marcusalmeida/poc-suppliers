package com.example.suppliers.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.suppliers.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
