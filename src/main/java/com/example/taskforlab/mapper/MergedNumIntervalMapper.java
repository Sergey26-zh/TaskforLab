package com.example.taskforlab.mapper;

import com.example.taskforlab.dto.MergedNumDto;
import com.example.taskforlab.entity.MergedNumInterval;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MergedNumIntervalMapper {
    MergedNumDto toDto (MergedNumInterval mergedNumInterval);
    MergedNumInterval toEntity (MergedNumDto mergedNumDto);
}
