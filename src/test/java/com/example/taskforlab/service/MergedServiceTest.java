package com.example.taskforlab.service;

import com.example.taskforlab.dto.NumericIntervalDto;
import com.example.taskforlab.dto.StringIntervalDto;
import com.example.taskforlab.entity.MergedNumInterval;
import com.example.taskforlab.entity.MergedStrInterval;
import com.example.taskforlab.mapper.MergedNumIntervalMapper;
import com.example.taskforlab.mapper.MergedStrIntervalMapper;
import com.example.taskforlab.repository.MergedNumRepository;
import com.example.taskforlab.repository.MergedStrRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MergedServiceTest {

    @Mock
    private MergedNumRepository mergedNumRepository;

    @Mock
    private MergedStrRepository mergedStrRepository;

    @Mock
    private MergedNumIntervalMapper numericIntervalMapper;

    @Mock
    private MergedStrIntervalMapper strIntervalMapper;

    @InjectMocks
    private MergedService mergedService;

    @Test
    public void testMergedAndSaveNumIntervals() {
        List<NumericIntervalDto> numericIntervals = Arrays.asList(
                new NumericIntervalDto(1L, 4L),
                new NumericIntervalDto(3L, 6L),
                new NumericIntervalDto(8L, 10L)
        );

        when(mergedNumRepository.saveAll(any())).thenReturn(new ArrayList<>());

        mergedService.mergedAndSaveNumIntervals(numericIntervals);

        verify(mergedNumRepository).saveAll(any());
    }

    @Test
    public void testMergedAndSaveStrIntervals() {
        List<StringIntervalDto> stringIntervals = Arrays.asList(
                new StringIntervalDto("a", "f"),
                new StringIntervalDto("d", "j"),
                new StringIntervalDto("r", "z")
        );

        when(mergedStrRepository.saveAll(any())).thenReturn(new ArrayList<>());

        mergedService.mergedAndSaveStrIntervals(stringIntervals);

        verify(mergedStrRepository).saveAll(any());
    }

    @Test
    public void testMergeNumericIntervals() {
        List<NumericIntervalDto> numericIntervals = Arrays.asList(
                new NumericIntervalDto(1L, 4L),
                new NumericIntervalDto(3L, 6L),
                new NumericIntervalDto(8L, 10L)
        );

        List<NumericIntervalDto> result = mergedService.mergeNumericIntervals(numericIntervals);

        assertEquals(2, result.size());

        NumericIntervalDto mergedInterval1 = result.get(0);
        assertEquals(1L, mergedInterval1.getStart().longValue());
        assertEquals(6L, mergedInterval1.getEnd().longValue());

        NumericIntervalDto mergedInterval2 = result.get(1);
        assertEquals(8L, mergedInterval2.getStart().longValue());
        assertEquals(10L, mergedInterval2.getEnd().longValue());
    }

    @Test
    public void testMergeStringIntervals() {
        List<StringIntervalDto> stringIntervals = Arrays.asList(
                new StringIntervalDto("a", "f"),
                new StringIntervalDto("d", "j"),
                new StringIntervalDto("r", "z")
        );

        List<StringIntervalDto> result = mergedService.mergeStringIntervals(stringIntervals);

        assertEquals(2, result.size());

        StringIntervalDto mergedInterval1 = result.get(0);
        assertEquals("a", mergedInterval1.getStart());
        assertEquals("j", mergedInterval1.getEnd());

        StringIntervalDto mergedInterval2 = result.get(1);
        assertEquals("r", mergedInterval2.getStart());
        assertEquals("z", mergedInterval2.getEnd());
    }
}