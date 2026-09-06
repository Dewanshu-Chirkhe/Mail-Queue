package com.mailqueue.controller;

import com.mailqueue.dto.CreateEmailRequest;
import com.mailqueue.dto.CreateEmailResponse;
import com.mailqueue.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmailResponse createEmail(
            @Valid @RequestBody CreateEmailRequest request
    ) {
        return emailService.createEmailJobs(request);
    }
}