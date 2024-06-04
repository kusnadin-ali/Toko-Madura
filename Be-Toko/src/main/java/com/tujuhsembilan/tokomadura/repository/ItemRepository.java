package com.tujuhsembilan.tokomadura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tujuhsembilan.tokomadura.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}