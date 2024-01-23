package com.example.taskforlab.repository;

import com.example.taskforlab.entity.MergedNumInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MergedNumRepository extends JpaRepository<MergedNumInterval, Long> {
    @Query(value = "SELECT * FROM merged_num_interval ORDER BY start ASC LIMIT 1", nativeQuery = true)
    MergedNumInterval findMinNumericInterval();
}
