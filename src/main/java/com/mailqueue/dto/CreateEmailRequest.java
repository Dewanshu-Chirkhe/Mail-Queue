package com.mailqueue.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CreateEmailRequest {

    @NotEmpty(message = "At least one recipient is required")
    private List<
            @Email(message = "Invalid email address")
            @NotBlank(message = "Recipient cannot be blank")
                    String
            > recipients;

    @NotBlank(message = "Subject is required")
    @Size(max = 255, message = "Subject cannot exceed 255 characters")
    private String subject;

    @NotBlank(message = "Body is required")
    private String body;

    private LocalDateTime scheduledAt;
}