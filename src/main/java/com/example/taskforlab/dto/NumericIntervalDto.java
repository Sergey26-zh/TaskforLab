package com.example.taskforlab.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumericIntervalDto {
    private Long start;
    private Long end;
}

