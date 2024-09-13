package com.semihtumay.cqrspattern.application.command;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public record UpdateProductCommand(Optional<String> name, Optional<BigDecimal> price, Optional<Integer> stock) {
}
