package com.dharbor.workflow.model;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkflowInstanceResponseList {

	private List<WorkflowInstanceResponse> workflowInstanceResponses;
	
	public WorkflowInstanceResponseList(){
		workflowInstanceResponses = new ArrayList<>();
	}
	
	
}
