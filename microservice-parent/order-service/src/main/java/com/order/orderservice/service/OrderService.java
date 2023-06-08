package com.order.orderservice.service;


import com.order.orderservice.dto.OrderLineItemsDto;
import com.order.orderservice.dto.OrderRequest;
import com.order.orderservice.model.Order;
import com.order.orderservice.model.OrderLineItems;
import com.order.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

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
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItems(orderLineItems);

        //call Inventory service & place order if product is in stock
        Boolean result = webClient.get()
                        .uri("http://localhost:8082/api/inventory")
                                .retrieve()
                                        .bodyToMono(Boolean.class)
                                                .block();
        if(result){
            orderRepository.save(order);
        }
        else{
            throw new IllegalArgumentException("Product is not in stock, pls try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItemsDTO.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        return orderLineItems;

    }
}
