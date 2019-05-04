package com.dharbor.workflow.model;

public class CasePatchDetails {

	private int StatusCodeNumber;

	public int getStatusCodeNumber() {
		return StatusCodeNumber;
	}

	public void setStatusCodeNumber(int statusCodeNumber) {
		StatusCodeNumber = statusCodeNumber;
	}

	@Override
	public String toString() {
		return "CastPatchDetails [StatusCodeNumber=" + StatusCodeNumber + "]";
	}
}
