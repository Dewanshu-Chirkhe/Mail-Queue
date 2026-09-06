package com.mailqueue.repository;

import com.mailqueue.entity.EmailJob;
import com.mailqueue.entity.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EmailJobRepository extends JpaRepository<EmailJob, Long> {

    List<EmailJob> findByStatusAndScheduledAtLessThanEqual(
            JobStatus status,
            LocalDateTime time
    );

    List<EmailJob> findByStatusAndNextRetryAtLessThanEqual(
            JobStatus status,
            LocalDateTime time
    );
}