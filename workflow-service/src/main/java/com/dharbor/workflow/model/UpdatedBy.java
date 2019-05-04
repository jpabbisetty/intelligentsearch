package com.dharbor.workflow.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author sgollapinni
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatedBy {

    @NotNull(message = "User Id cannot be null")
    private String id;

    @NotNull(message = "User activityRole cannot be null")
    private String role;

}