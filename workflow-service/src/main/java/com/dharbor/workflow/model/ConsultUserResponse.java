package com.dharbor.workflow.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ConsultUserResponse {

    String userId;

    String consultRole;

    String consultType;

    @JsonIgnore
    private String startDate;

    @JsonIgnore
    private String endDate;

}