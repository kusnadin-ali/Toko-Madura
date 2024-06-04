package com.tujuhsembilan.tokomadura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tujuhsembilan.tokomadura.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}