package com.semihtumay.cqrspattern.application.query;

import co.elastic.clients.elasticsearch.core.search.Hit;
import com.semihtumay.cqrspattern.application.query.dto.ProductResponse;
import com.semihtumay.cqrspattern.application.query.mapper.ProductMapper;
import com.semihtumay.cqrspattern.domain.Product;
import com.semihtumay.cqrspattern.infrastructure.elasticsearch.ElasticsearchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductQueryHandler {

    private final ElasticsearchService elasticsearchService;

    public ProductQueryHandler(ElasticsearchService elasticsearchService) {
        this.elasticsearchService = elasticsearchService;
    }

    public ProductResponse getProductById(String id) {

        try {
            List<Hit<Product>> hits = elasticsearchService.searchById("products", id, Product.class);
            List<Product> products = hits.stream().map(Hit::source).toList();
            System.err.println(products);
            return ProductMapper.mapper(products.get(0));
        }catch (Exception e){
            throw new IllegalArgumentException("Product not found in Elasticsearch");
        }

    }

    public List<ProductResponse> getProductsByName(String name) {

        try {
            List<Hit<Product>> hits = elasticsearchService.searchByName("products", name, Product.class);
            List<Product> products = hits.stream().map(Hit::source).toList();
            return products.stream().map(ProductMapper::mapper).collect(Collectors.toList());
        }catch (Exception e){
            throw new IllegalArgumentException("Product not found in Elasticsearch");
        }
    }
}
