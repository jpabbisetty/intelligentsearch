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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * Runtime workflow execution history instance entity
 * @author sgollapinni
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkflowHistoryInstance extends AbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;

	@Column(name="source_event_name")
    private String eventName;

    @Column(name="consult_user_id")
    private String consultUserId;

    @Column(name="consulted_role")
    private String consultedRole;

    @Column(name="consulted_at")
    private String consultedAt;

    @Column(name="consult_expired_at")
    private String consultExpiredAt;

    @Column(name="user_action")
    private String userAction;

    @Column(name="consult_type")
    private String consultType;

    public WorkflowHistoryInstance(WorkflowInstance workflowInstance, String eventName) {
        if(workflowInstance != null) {
            setRuntimeInstanceToHistoryEntity(workflowInstance, eventName);
        }
    }

    public WorkflowHistoryInstance(WorkflowInstance workflowInstance, String eventName, String consultUserId, String consultedAt, String consultExpiredAt,
                                   String consultedRole) {
        if(workflowInstance != null) {
            setRuntimeInstanceToHistoryEntity(workflowInstance, eventName);
            this.setConsultUserId(consultUserId);
            this.setConsultedAt(consultedAt);
            this.setConsultExpiredAt(consultExpiredAt);
            this.setConsultedRole(consultedRole);
        }
    }

    public WorkflowHistoryInstance(WorkflowInstance workflowInstance, String eventName, String consultUserId, String consultedAt, String consultExpiredAt,
                                   String consultedRole, ConsultType consultType) {
        if(workflowInstance != null) {
            setRuntimeInstanceToHistoryEntity(workflowInstance, eventName);
            this.setConsultUserId(consultUserId);
            this.setConsultedAt(consultedAt);
            this.setConsultExpiredAt(consultExpiredAt);
            this.setConsultedRole(consultedRole);
            this.setConsultType(consultType.name());
        }
    }

    private void setRuntimeInstanceToHistoryEntity(WorkflowInstance workflowInstance, String eventName) {
        this.setInstanceId(workflowInstance.getInstanceId());
        this.setEntityId(workflowInstance.getEntityId());
        this.setWorkflowDefId(workflowInstance.getWorkflowDefId());
        this.setActivityDefId(workflowInstance.getActivityDefId());
        this.setActivityState(workflowInstance.getActivityState());
        this.setActivityName(workflowInstance.getActivityName());
        this.setActivityType(workflowInstance.getActivityType());
        this.setActivityAssignee(workflowInstance.getActivityAssignee());
        this.setActivityRole(workflowInstance.getActivityRole());
        this.setUpdatedBy(workflowInstance.getUpdatedBy());
        this.setMilestoneName(workflowInstance.getMilestoneName());
        this.setSubMilestoneName(workflowInstance.getSubMilestoneName());
        this.setWorkflowStatus(workflowInstance.getWorkflowStatus());
        this.setSubscriptionId(workflowInstance.getSubscriptionId());
        this.setWorkflowDefQueueId(workflowInstance.getWorkflowDefQueueId());
        if(workflowInstance.getUpdatedAt() == null) {
            this.setCreatedAt(workflowInstance.getCreatedAt());
        } else {
            this.setCreatedAt(workflowInstance.getUpdatedAt());
        }

        this.eventName = eventName;
        this.setUserAction(workflowInstance.getUserAction());
    }
}
