package com.mailqueue.service;

import com.mailqueue.dto.CreateEmailRequest;
import com.mailqueue.dto.CreateEmailResponse;
import com.mailqueue.entity.EmailJob;
import com.mailqueue.entity.JobStatus;
import com.mailqueue.repository.EmailJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailJobRepository emailJobRepository;

    @Transactional
    public CreateEmailResponse createEmailJobs(CreateEmailRequest request) {

        List<EmailJob> jobs = new ArrayList<>();

        for (String recipient : request.getRecipients()) {

            EmailJob job = new EmailJob();

            job.setRecipient(recipient);
            job.setSubject(request.getSubject());
            job.setBody(request.getBody());

            job.setStatus(JobStatus.PENDING);
            job.setRetryCount(0);
            job.setMaxRetries(3);

            job.setScheduledAt(request.getScheduledAt());

            job.setCreatedAt(LocalDateTime.now());
            job.setUpdatedAt(LocalDateTime.now());

            jobs.add(job);
        }

        List<EmailJob> savedJobs = emailJobRepository.saveAll(jobs);

        List<Long> jobIds = savedJobs.stream()
                .map(EmailJob::getId)
                .toList();

        return new CreateEmailResponse(
                savedJobs.size(),
                jobIds
        );
    }
}