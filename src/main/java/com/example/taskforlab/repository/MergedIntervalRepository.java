package com.example.taskforlab.repository;

import com.example.taskforlab.entity.MergedInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MergedIntervalRepository extends JpaRepository<MergedInterval, Long> {
}
