package com.amzur.order_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amzur.order_management.dto.request.OrderRequest;
import com.amzur.order_management.dto.response.OrderResponse;
import com.amzur.order_management.entities.LineItemEntity;
import com.amzur.order_management.entities.OrderEntity;
import com.amzur.order_management.repository.LineItemRepository;
import com.amzur.order_management.repository.OrderRepository;

@Service
public class OrderServiceIml implements OrderService{
	@Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LineItemRepository lineItemRepository;

	@Override
	public OrderResponse createOrder(OrderRequest orderRequest) {
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setUserId(orderRequest.getUserId());
		BeanUtils.copyProperties(orderRequest,orderEntity);

		orderEntity = orderRepository.save(orderEntity);
		final Long orderId = orderEntity.getId();
		List<LineItemEntity> lineItems = orderRequest.getBookIds().stream()
		    .map(bookId -> {
		        LineItemEntity lineItem = new LineItemEntity();
		        lineItem.setOrderId(orderId);
		        lineItem.setBookId(bookId);
		        return lineItem;
		    })
		    .collect(Collectors.toList());

		lineItemRepository.saveAll(lineItems);
		OrderResponse orderResponse = new OrderResponse();
//		orderResponse.setOrderId(orderId);
		BeanUtils.copyProperties(orderEntity,orderResponse);
		return orderResponse;
	}

	@Override
	public List<OrderResponse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderResponse findByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		
	}

}
