package com.dharbor.workflow.model;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


/**
 * workflow milestone instance response
 * @author sgollapinni
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WorkflowMilestoneAssigneeResponse {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userName;

    private String firstName;

    private String lastName;

    private String role;

    private String createdAt;

}
