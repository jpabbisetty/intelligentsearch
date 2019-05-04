package com.dharbor.workflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWorkloadResponse {

    @JsonIgnore
    private String userId;

    private String assigned;
    private String assignmentrequested;
    private String inprogress;
}
