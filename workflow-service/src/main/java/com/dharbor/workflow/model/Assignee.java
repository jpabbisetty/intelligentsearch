package com.dharbor.workflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sgollapinni
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Assignee {

    @NotNull(message = "Assignee Id cannot be null")
    private String id;

    @NotNull(message = "Assignee activityRole cannot be null")
    private String role;

}