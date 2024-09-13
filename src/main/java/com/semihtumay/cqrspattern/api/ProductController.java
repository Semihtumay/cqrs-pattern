package com.semihtumay.cqrspattern.api;

import com.semihtumay.cqrspattern.application.command.CreateProductCommand;
import com.semihtumay.cqrspattern.application.command.ProductCommandHandler;
import com.semihtumay.cqrspattern.application.command.UpdateProductCommand;
import com.semihtumay.cqrspattern.application.query.ProductQueryHandler;
import com.semihtumay.cqrspattern.application.query.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductCommandHandler productCommandHandler;
    private final ProductQueryHandler productQueryHandler;

    public ProductController(ProductCommandHandler productCommandHandler, ProductQueryHandler productQueryHandler) {
        this.productCommandHandler = productCommandHandler;
        this.productQueryHandler = productQueryHandler;
    }

    @PostMapping
    public void createProduct(@Valid @RequestBody CreateProductCommand command) {
        productCommandHandler.handleCreateProduct(command);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable UUID id, @RequestBody UpdateProductCommand command) {
        productCommandHandler.handleUpdateProduct(id, command);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable String id) {
        return productQueryHandler.getProductById(id);
    }

    @GetMapping("/search")
    public List<ProductResponse> getProductByName(@RequestParam String name) {
        return productQueryHandler.getProductsByName(name);
    }
}
