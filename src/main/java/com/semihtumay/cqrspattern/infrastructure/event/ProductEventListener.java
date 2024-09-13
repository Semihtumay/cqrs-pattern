package com.semihtumay.cqrspattern.infrastructure.event;

import com.semihtumay.cqrspattern.application.event.ProductCreatedEvent;
import com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent;
import com.semihtumay.cqrspattern.infrastructure.elasticsearch.ElasticsearchService;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class ProductEventListener {

    private final ElasticsearchService elasticsearchService;

    public ProductEventListener(ElasticsearchService elasticsearchService) {
        this.elasticsearchService = elasticsearchService;

    }

    @KafkaListener(topics = "product-created", groupId = "group_id")
    public void productCreated(ProductCreatedEvent event) throws IOException {
        String jsonEvent = convertAvroToJson(event);
        elasticsearchService.indexDocument("products", event.getId().toString(), jsonEvent);
    }

    @KafkaListener(topics = "product-updated", groupId = "group_id")
    public void productUpdated(ProductUpdatedEvent event) throws IOException {
        String jsonEvent = convertAvroToJson(event);
        elasticsearchService.indexDocument("products", event.getId().toString(),jsonEvent);
    }

    private String convertAvroToJson(SpecificRecordBase avroRecord) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DatumWriter<SpecificRecordBase> writer = new SpecificDatumWriter<>(avroRecord.getSchema());
        Encoder encoder = EncoderFactory.get().jsonEncoder(avroRecord.getSchema(), outputStream);

        writer.write(avroRecord, encoder);
        encoder.flush();

        return outputStream.toString(StandardCharsets.UTF_8);
    }


}
