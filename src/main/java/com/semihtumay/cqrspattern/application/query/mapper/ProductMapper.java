package com.semihtumay.cqrspattern.application.query.mapper;

import com.semihtumay.cqrspattern.application.query.dto.ProductResponse;
import com.semihtumay.cqrspattern.domain.Product;

public class ProductMapper {

    public static ProductResponse mapper(Product product){

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
    }
}
