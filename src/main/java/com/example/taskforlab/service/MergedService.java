package com.example.taskforlab.service;

import com.example.taskforlab.repository.MergedNumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MergedService {
    private final MergedNumRepository mergedNumRepository;


}
