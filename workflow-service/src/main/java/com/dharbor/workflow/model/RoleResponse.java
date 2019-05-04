package com.dharbor.workflow.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RoleResponse extends BaseResponse{

    private Long id;
    private String name;
    private String uuid;
    private String uid;
}
