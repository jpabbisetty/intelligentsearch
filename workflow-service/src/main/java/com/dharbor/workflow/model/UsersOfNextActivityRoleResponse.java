package com.dharbor.workflow.model;

import java.util.List;

import lombok.Data;
import org.springframework.hateoas.PagedResources;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersOfNextActivityRoleResponse {

    private String roleName;
    private List<UserResponseWithWorkload> users;
    private PagedResources.PageMetadata page;
    
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserResponseWithWorkload> getUsers() {
		return users;
	}
	public void setUsers(List<UserResponseWithWorkload> users) {
		this.users = users;
	}
	public PagedResources.PageMetadata getPage() {
		return page;
	}
	public void setPage(PagedResources.PageMetadata page) {
		this.page = page;
	}
    
    
}
