package com.dharbor.workflow.model;
 
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sgollapinni
 */
@Data
public class WorkflowInitiateRequest {

    @NotNull(message = "Entity Id cannot be null")
    private String entityId;

    private UpdatedBy updatedBy;
}
