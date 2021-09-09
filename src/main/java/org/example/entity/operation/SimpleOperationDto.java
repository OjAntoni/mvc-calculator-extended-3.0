package org.example.entity.operation;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor
public class SimpleOperationDto {
    @NotNull
    public double num1;
    @NotNull
    public double num2;
    @NotEmpty
    @NotNull
    @Pattern(regexp = "sum|div|sub|mult")
    public String operationSign;
}
