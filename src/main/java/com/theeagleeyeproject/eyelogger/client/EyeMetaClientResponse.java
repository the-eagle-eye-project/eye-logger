package com.theeagleeyeproject.eyelogger.client;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EyeMetaClientResponse {

    private String integrationId;

    private String applicationName;

    private String applicationType;

    private String applicationStep;

    private List<String> relatedIntegrationIds;

    private long logsTtl;

    private boolean isActive;

    private LocalDateTime recordCreatedTimestamp;

    private LocalDateTime recordUpdatedTimestamp;

    private String recordCreatedBy;

    private String recordUpdatedBy;

}