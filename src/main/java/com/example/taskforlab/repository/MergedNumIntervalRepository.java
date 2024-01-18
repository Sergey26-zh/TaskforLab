package com.example.taskforlab.repository;

import com.example.taskforlab.entity.MergedNumInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MergedNumIntervalRepository extends JpaRepository<MergedNumInterval, Long> {
}
