package com.example.taskforlab.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StringIntervalDto {
    private Character start;
    private Character end;
}
