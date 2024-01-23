package com.example.taskforlab.mapper;

import com.example.taskforlab.dto.MergedStrDto;
import com.example.taskforlab.entity.MergedStrInterval;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MergedStrIntervalMapper {
    MergedStrDto toDto(MergedStrInterval mergedStrInterval);
    MergedStrInterval toEntity(MergedStrDto mergedStrDto);
}
