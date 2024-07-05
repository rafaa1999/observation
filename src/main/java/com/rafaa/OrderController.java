package com.rafaa;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id){
        log.info("OrderController.findById(id)");
        return this.orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: %d".formatted(id)));
    }

}
