package com.example.taskforlab.service;

import com.example.taskforlab.dto.MergedNumDto;
import com.example.taskforlab.dto.MergedStrDto;
import com.example.taskforlab.dto.NumericIntervalDto;
import com.example.taskforlab.dto.StringIntervalDto;
import com.example.taskforlab.entity.MergedNumInterval;
import com.example.taskforlab.entity.MergedStrInterval;
import com.example.taskforlab.mapper.MergedNumIntervalMapper;
import com.example.taskforlab.mapper.MergedStrIntervalMapper;
import com.example.taskforlab.repository.MergedNumRepository;
import com.example.taskforlab.repository.MergedStrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MergedService {
    private final MergedNumRepository mergedNumRepository;
    private final MergedStrRepository mergedStrRepository;
    private final MergedNumIntervalMapper numericIntervalMapper;
    private final MergedStrIntervalMapper strIntervalMapper;


    @Transactional
    public void mergedAndSaveNumIntervals(List<NumericIntervalDto> numericIntervals) {
        List<NumericIntervalDto> mergedIntervals = mergeNumericIntervals(numericIntervals);
        List<MergedNumDto> mergedNumDtos = new ArrayList<>();
        List<MergedNumInterval> mergedNumIntervals = mergedNumDtos.stream()
                .map(numericIntervalMapper::toEntity)
                .collect(Collectors.toList());

        mergedNumRepository.saveAll(mergedNumIntervals);
    }

    @Transactional
    public void mergedAndSaveStrIntervals(List<StringIntervalDto> stringIntervals) {
        List<StringIntervalDto> mergedIntervals = mergeStringIntervals(stringIntervals);
        List<MergedStrDto> mergedStrDtos = new ArrayList<>();
        List<MergedStrInterval> mergedStrIntervals = mergedStrDtos.stream()
                .map(strIntervalMapper::toEntity)
                .collect(Collectors.toList());

        mergedStrRepository.saveAll(mergedStrIntervals);
    }

    public MergedNumDto getMinNumericInterval() {
        MergedNumInterval minNumInterval = mergedNumRepository.findMinNumericInterval();
        return (minNumInterval != null) ? numericIntervalMapper.toDto(minNumInterval) : null;
    }

    public MergedStrDto getMinStringInterval() {
        MergedStrInterval minStrInterval = mergedStrRepository.findMinStringInterval();
        return (minStrInterval != null) ? strIntervalMapper.toDto(minStrInterval) : null;
    }

    private List<StringIntervalDto> mergeStringIntervals(List<StringIntervalDto> stringIntervals) {
        stringIntervals.sort(Comparator.comparing(StringIntervalDto::getStart));

        List<StringIntervalDto> mergedIntervals = new ArrayList<>();
        StringIntervalDto currentInterval = stringIntervals.get(0);

        for (int i = 1; i < stringIntervals.size(); i++) {
            StringIntervalDto nextInterval = stringIntervals.get(i);

            if (canMerge(currentInterval, nextInterval)) {
                currentInterval = mergeIntervals(currentInterval, nextInterval);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }

    private boolean canMerge(StringIntervalDto interval1, StringIntervalDto interval2) {
        return interval1.getEnd().compareTo(interval2.getStart()) >= 0;
    }

    private StringIntervalDto mergeIntervals(StringIntervalDto interval1, StringIntervalDto interval2) {
        return new StringIntervalDto(interval1.getStart(), maxString(interval1.getEnd(), interval2.getEnd()));
    }

    private String maxString(String str1, String str2) {
        return str1.compareTo(str2) >= 0 ? str1 : str2;
    }

    private List<NumericIntervalDto> mergeNumericIntervals(List<NumericIntervalDto> numericIntervals) {
        numericIntervals.sort(Comparator.comparing(NumericIntervalDto::getStart));

        List<NumericIntervalDto> mergedIntervals = new ArrayList<>();
        NumericIntervalDto currentInterval = numericIntervals.get(0);

        for (int i = 1; i < numericIntervals.size(); i++) {
            NumericIntervalDto nextInterval = numericIntervals.get(i);

            if (canMerge(currentInterval, nextInterval)) {
                currentInterval = mergeIntervals(currentInterval, nextInterval);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }

    private boolean canMerge(NumericIntervalDto interval1, NumericIntervalDto interval2) {
        return interval1.getEnd() >= interval2.getStart();
    }

    private NumericIntervalDto mergeIntervals(NumericIntervalDto interval1, NumericIntervalDto interval2) {
        return new NumericIntervalDto(interval1.getStart(), Math.max(interval1.getEnd(), interval2.getEnd()));
    }
}
