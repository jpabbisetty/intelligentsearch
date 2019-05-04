package com.dharbor.workflow.model;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


/**
 * workflow milestone instance response
 * @author sgollapinni
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkflowMilestoneResponse {

	private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String type;

    private Boolean completed;

    private WorkflowMilestoneAssigneeResponse assigner;

    private WorkflowMilestoneAssigneeResponse assignee;

    private WorkflowMilestoneAssigneeResponse completedBy;
}
