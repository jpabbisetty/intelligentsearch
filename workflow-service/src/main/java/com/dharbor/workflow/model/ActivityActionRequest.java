package com.dharbor.workflow.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author sgollapinni
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityActionRequest {

	@NotNull(message = "workflow instance id cannot be null")
    private String instanceId;

    private String entityId;

    @NotNull(message = "Activity Id cannot be null")
    private String activityDefId;

    private String nextActivity;

    private Assignee assignee;

    private UpdatedBy updatedBy;

    private Boolean requestAssignment;

    private String consultDays = "365";

    private String userActions;

    @JsonIgnore
    private String subscriptionId;

}
