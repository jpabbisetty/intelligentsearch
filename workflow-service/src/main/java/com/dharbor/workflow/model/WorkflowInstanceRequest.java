package com.dharbor.workflow.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author sgollapinni
 */
@Data
public class WorkflowInstanceRequest {

	  private static final long serialVersionUID = 1L;

	    private Long id;

	    private String instanceId;

	    private String entityId;

	    private String workflowDefId;

	    private Status workflowStatus;

	    private String updatedBy;

	    private Boolean consultAllowed;

	    //private LocalDateTime createdAt;

	    //private LocalDateTime updatedAt;

	    private Long daysRemaining;

	    @JsonProperty("currentActivity")
	    private WorkflowInstanceActivityResponse activityResponse;
}
