package com.semihtumay.cqrspattern.application.query.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id, String name, BigDecimal price, Integer stock) {
}
