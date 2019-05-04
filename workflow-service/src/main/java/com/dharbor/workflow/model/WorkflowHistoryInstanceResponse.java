/*
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
 * Copyright © 2002-2018, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
 * icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
 * photocopying, recording, or otherwise, without written permission of Digital Harbor.
 */

package com.dharbor.workflow.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Runtime workflow execution history instance entity
 * @author sgollapinni
 */

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class WorkflowHistoryInstanceResponse {

    private Long id;

	private String instanceId;

    private String createdAt;

	private String entityId;

	private String workflowDefId;

    private String updatedBy;

    private String milestoneId;

    private String milestoneName;

    private Status milestoneStatus;

    private String subMilestoneId;

    private String subMilestoneName;

    private Status subMilestoneStatus;

    private Status workflowStatus;

    private String eventName;

    private String subscriptionId;

    @JsonProperty("activity")
    private WorkflowInstanceActivityResponse activityResponse;

    public WorkflowHistoryInstanceResponse(WorkflowHistoryInstance instance) {
        if(instance != null) {
            this.instanceId = instance.getInstanceId();
            this.entityId = instance.getEntityId();
            this.workflowDefId = instance.getWorkflowDefId();
            this.updatedBy = instance.getUpdatedBy();
            this.milestoneName = instance.getMilestoneName();
            this.subMilestoneName = instance.getSubMilestoneName();
            this.workflowStatus = instance.getWorkflowStatus();
            this.subscriptionId = instance.getSubscriptionId();
            this.eventName = instance.getEventName();
            this.createdAt = instance.getCreatedAt();
            List<ConsultUserResponse> consultUsers = null;
            if(instance.getConsultUserId() != null) {
                consultUsers = new ArrayList<>();
                ConsultUserResponse consultUserResponse = new ConsultUserResponse();
                consultUserResponse.setUserId(instance.getConsultUserId());
                consultUserResponse.setStartDate(instance.getConsultedAt());
                consultUserResponse.setEndDate(instance.getConsultExpiredAt());
                consultUserResponse.setConsultRole(instance.getConsultedRole());
                consultUsers.add(consultUserResponse);
            }
            WorkflowInstanceActivityResponse activityResponseObj =
                    new WorkflowInstanceActivityResponse(instance.getActivityDefId(),
                            instance.getActivityState(), instance.getActivityName(), instance.getActivityType(), instance.getActivityAssignee(),
                            instance.getActivityRole(), instance.getMilestoneName(), instance.getSubMilestoneName(), instance.getWorkflowDefQueueId(), consultUsers,
                            instance.getUserAction(), null);
            this.setActivityResponse(activityResponseObj);
        }
    }
}
