package com.dharbor.workflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

import java.util.List;


@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstancesByQueueResponse {

    private static final long serialVersionUID = 1L;

    private List<String> actions;

    private PagedResources<Resource<InstancesByQueueResponseChild>> instances;

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public PagedResources<Resource<InstancesByQueueResponseChild>> getInstances() {
		return instances;
	}

	public void setInstances(
			PagedResources<Resource<InstancesByQueueResponseChild>> instances) {
		this.instances = instances;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
