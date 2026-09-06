package com.mailqueue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateEmailResponse {

    private int jobsCreated;
    private List<Long> jobIds;
}