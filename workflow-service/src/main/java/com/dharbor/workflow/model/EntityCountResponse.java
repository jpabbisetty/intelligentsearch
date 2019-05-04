package com.dharbor.workflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityCountResponse {

    private Long assignCount;
    private Long unassignCount;
    private Long teamCount;
    private Long closeCount;

}