package com.semihtumay.cqrspattern.application.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProductCommand(
       @NotBlank String name,
       @NotNull @Min(value = 0, message = "Price must be zero or greater") BigDecimal price,
       @NotNull @Min(value = 0, message = "Stock must be zero or greater") Integer stock) {
}
