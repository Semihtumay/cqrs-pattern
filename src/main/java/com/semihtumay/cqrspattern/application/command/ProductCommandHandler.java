package com.semihtumay.cqrspattern.application.command;

import com.semihtumay.cqrspattern.domain.Product;
import com.semihtumay.cqrspattern.infrastructure.event.KafkaEventPublisher;
import com.semihtumay.cqrspattern.infrastructure.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ProductCommandHandler {

    private final ProductRepository productRepository;
    private final KafkaEventPublisher kafkaEventPublisher;

    public ProductCommandHandler(ProductRepository productRepository, KafkaEventPublisher kafkaEventPublisher) {
        this.productRepository = productRepository;
        this.kafkaEventPublisher = kafkaEventPublisher;
    }

    @Transactional
    public void handleCreateProduct(CreateProductCommand command){
        Product product = new Product();
        product.setName(command.name());
        product.setPrice(command.price());
        product.setStock(command.stock());
        productRepository.save(product);

        kafkaEventPublisher.publishProductCreatedEvent(product);
    }

    @Transactional
    public void handleUpdateProduct(UUID id, UpdateProductCommand command){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        command.name().ifPresent(product::setName);
        command.price().ifPresent(product::setPrice);
        command.stock().ifPresent(product::setStock);
        productRepository.save(product);

        kafkaEventPublisher.publishProductUpdatedEvent(product);
    }
}
