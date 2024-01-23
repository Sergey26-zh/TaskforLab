package com.example.taskforlab.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StringIntervalDto {
    private String start;
    private String end;
}
