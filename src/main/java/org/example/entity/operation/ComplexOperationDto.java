package org.example.entity.operation;

import lombok.AllArgsConstructor;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
public class ComplexOperationDto {
    public double x1;
    public double x2;
    public double y1;
    public double y2;
    @Pattern(regexp = "sum|div|sub|mult")
    public String operationSign;
}
