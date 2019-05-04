/*******************************************************************************
 * Digital Harbor International, Inc. makes no representations or warranties with respect to the contents or use of this manual,
 * and specifically disclaims any express or implied warranties of merchantability or fitness for any particular purpose. Digital
 * Harbor, Inc. reserves the right to revise this publication and to make changes to its content, at any time, without obligation to
 * notify any person or entity of such revisions or changes. Digital Harbor International, Inc. makes no representations or
 * warranties with respect to any Digital Harbor software, and specifically disclaims any express or implied warranties of
 * merchantability or fitness for any particular purpose. There are no warranties that extend beyond the descriptions contained in
 * these paragraphs. No warranty may be created or extended by sales representatives or written sales materials. Digital Harbor,
 * Inc. reserves the right to make changes to any and all parts of Digital Harbor software, at any time, without any obligation to
 * notify any person or entity of such changes. Digital Harbor, Inc. shall not be liable for any loss of profit or any other commercial
 * damages, including but not limited to special, incidental, consequential, or other damages.
 * 
 * Copyright © 2002-2017, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
 * icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
 * photocopying, recording, or otherwise, without written permission of Digital Harbor.
 ******************************************************************************/
package com.dharbor.workflow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Abstract entity for Entity classes
 * @author sgollapinni
 *
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

	@Column(name = "instance_id")
	private String instanceId;

	@Column(name = "entity_id")
	private String entityId;

	@Column(name = "workflow_definition_id")
	private String workflowDefId;

	@Column(name="activity_id")
	private String activityDefId;

	@Column(name = "activity_state")
	private ActivityState activityState;

	@Column(name = "activity_name")
	private String activityName;

	@Column(name = "activity_type")
	private String activityType;

	@Column(name="activity_assignee")
	private String activityAssignee;

	@Column(name="activity_role")
	private String activityRole;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="milestone_name")
	private String milestoneName;

	@Column(name="sub_milestone_name")
	private String subMilestoneName;

	@Column(name="workflow_status")
	private Status workflowStatus;

	@Column(name="workflow_definition_queue_id")
	private String workflowDefQueueId;

	@Column(name="subscription_id")
	private String subscriptionId;

    private String createdAt;

    private String updatedAt;

    @Column(name="execution_counter")
	private Integer executionCounter = 1;

    @Column(name="reinitiated_skip_to_activity_id")
    private String reinitiateSkipToActivityId;

	/*private int generateHashCode() {
		return Objects.hash(createdAt, updatedAt);
	}*/

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return doEquality(obj);
	}*/

	/*@Override
	public int hashCode() {
		return generateHashCode();
	}*/

    /*private boolean doEquality(Object obj) {
        AbstractEntity abstractEntity = (AbstractEntity) obj;
        return Objects.equals(this.createdAt, abstractEntity.getCreatedAt())
                && Objects.equals(this.updatedAt, abstractEntity.getUpdatedAt());
    }*/

}
