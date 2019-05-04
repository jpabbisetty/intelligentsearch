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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Runtime workflow instance entity
 * @author sgollapinni
 */

@Data
public class WorkflowInstance extends AbstractEntity implements Serializable {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;

    /*@PrePersist
    void onCreate() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }*/

    @Column(name="user_action")
    private String userAction;

}