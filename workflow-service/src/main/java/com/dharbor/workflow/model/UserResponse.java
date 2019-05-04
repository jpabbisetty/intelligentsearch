package com.dharbor.workflow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class UserResponse {
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    private Boolean enabled;
    private String phoneNumber;
    private Boolean enableLucy;
    private Boolean enableAnimation;
    private String avatar;
    private Set<RoleResponse> roles;
    private String authToken;
    private String userId;
    private Boolean locked;
    private Boolean isDeleted;
}

