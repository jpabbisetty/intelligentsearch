package com.dharbor.workflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolesOfNextActivityResponse {

    private String activityName;
    private List<UsersOfNextActivityRoleResponse> roles;

}