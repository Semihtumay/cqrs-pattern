package com.semihtumay.cqrspattern.infrastructure.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ElasticsearchService {

    private final ElasticsearchClient elasticsearchClient;

    public ElasticsearchService(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }


    public void indexDocument(String index, String id, String jsonDocument) throws IOException {
        Map<String, Object> document = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        document = mapper.readValue(jsonDocument, new TypeReference<Map<String, Object>>() {});

        Map<String, Object> finalDocument = document;
        IndexRequest<Map<String, Object>> request = IndexRequest.of(i -> i
                .index(index)
                .id(id)
                .document(finalDocument)
        );

        elasticsearchClient.index(request);
    }

    public <T> List<Hit<T>> searchByName(String indexName, String name, Class<T> documentClass) throws IOException {
        Query query = Query.of(q -> q
                .match(m -> m
                        .field("name")
                        .query(name)
                )
        );

        SearchResponse<T> response = elasticsearchClient.search(s -> s
                        .index(indexName)
                        .query(query),
                documentClass
        );
        return response.hits().hits();
    }

    public <T> List<Hit<T>> searchById(String indexName, String id, Class<T> documentClass) throws IOException {
        Query query = Query.of(q -> q
                .term(t -> t
                        .field("id.keyword")
                        .value(id)
                )
        );

        SearchResponse<T> response = elasticsearchClient.search(s -> s
                        .index(indexName)
                        .query(query),
                documentClass
        );
        return response.hits().hits();
    }
}
