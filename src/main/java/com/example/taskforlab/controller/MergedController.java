package com.example.taskforlab.controller;

import com.example.taskforlab.dto.MergedNumDto;
import com.example.taskforlab.dto.MergedStrDto;
import com.example.taskforlab.dto.NumericIntervalDto;
import com.example.taskforlab.dto.StringIntervalDto;
import com.example.taskforlab.entity.MergedNumInterval;
import com.example.taskforlab.service.MergedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intervals")
@RequiredArgsConstructor
public class MergedController {
    private final MergedService mergedService;

    @PostMapping("/merge")
    public void mergeIntervals(@RequestParam("kind") String kind, @RequestBody List<?> intervals) {
        switch (kind) {
            case "digits":
                if (intervals.get(0) instanceof NumericIntervalDto) {
                    mergedService.mergedAndSaveNumIntervals((List<NumericIntervalDto>) intervals);
                }
                break;

            case "letters":
                if (intervals.get(0) instanceof StringIntervalDto) {
                    mergedService.mergedAndSaveStrIntervals((List<StringIntervalDto>) intervals);
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + kind);
        }
    }

    @GetMapping("/min")
    public ResponseEntity<?> getMinInterval(@RequestParam("kind") String kind) {
        return switch (kind) {
            case "digits" -> {
                MergedNumDto minNumericInterval = mergedService.getMinNumericInterval();
                yield ResponseEntity.ok(minNumericInterval);
            }
            case "letters" -> {
                MergedStrDto minStringInterval = mergedService.getMinStringInterval();
                yield ResponseEntity.ok(minStringInterval);
            }
            default -> ResponseEntity.badRequest().body("Invalid kind parameter.");
        };
    }
}

