package com.dharbor.workflow.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sgollapinni
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkflowInstanceActivityResponse {

	 private String id;

	    @JsonProperty("activityState")
	    private ActivityState state;

	    private String name;

	    private String type;

	    private String assignee;

	    private String role;

	    private String milestone;

	    private String subMilestone;

	    @JsonProperty("queue")
	    private String queueDefId;

	    @JsonProperty("consultUsers")
	    private List<ConsultUserResponse> consultDetail;

	    private String userAction;

	    private List<String> userActionsOptions;
}
