package com.semihtumay.cqrspattern.infrastructure.event;

import com.semihtumay.cqrspattern.application.event.ProductCreatedEvent;
import com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent;
import com.semihtumay.cqrspattern.domain.Product;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishProductCreatedEvent(Product product) {

        String uuid = product.getId().toString();
        String price = product.getPrice().toString();

        ProductCreatedEvent event = new ProductCreatedEvent(
                uuid,
                product.getName(),
                price,
                product.getStock());

        kafkaTemplate.send("product-created", event);
    }

    public void publishProductUpdatedEvent(Product product) {

        ProductUpdatedEvent event = new ProductUpdatedEvent(
                product.getId().toString(),
                product.getName(),
                product.getPrice().toString(),
                product.getStock());

        kafkaTemplate.send("product-updated", event);
    }
}
