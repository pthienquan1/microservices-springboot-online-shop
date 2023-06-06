package com.order.orderservice.service;


import com.order.orderservice.dto.OrderLineItemsDto;
import com.order.orderservice.dto.OrderRequest;
import com.order.orderservice.model.Order;
import com.order.orderservice.model.OrderLineItems;
import com.order.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by quan0
 * Date 6/6/2023 - 9:59 PM
 * Description: ...
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItems(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItemsDTO.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setSku(orderLineItemsDTO.getSku());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        return orderLineItems;

    }
}
