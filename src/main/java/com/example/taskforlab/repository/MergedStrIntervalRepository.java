package com.example.taskforlab.repository;

import com.example.taskforlab.entity.MergedStrInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MergedStrIntervalRepository extends JpaRepository<MergedStrInterval, Long> {
}
