package com.dharbor.workflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseWithWorkload {

    private UserResponse detail;
    private UserWorkloadResponse workload;
}
