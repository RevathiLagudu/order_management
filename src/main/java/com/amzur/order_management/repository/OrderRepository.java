package com.amzur.order_management.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amzur.order_management.entities.LineItemEntity;
import com.amzur.order_management.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

	List<OrderEntity> getByUserId(Long userId);

}
