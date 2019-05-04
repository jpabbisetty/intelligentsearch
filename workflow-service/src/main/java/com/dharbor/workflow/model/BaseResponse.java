package com.dharbor.workflow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseResponse {

    private Date createdAt;
    private Date updatedAt;
}
