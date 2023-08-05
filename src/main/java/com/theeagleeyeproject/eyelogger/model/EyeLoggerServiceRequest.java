package com.theeagleeyeproject.eyelogger.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EyeLoggerServiceRequest {

    private String transactionId;

    private String applicationName;

    private String applicationStep;

    private LocalDateTime eventTimestamp;

    private String requestBody;

    private String requestUri;

    private String sourceHost;

    private TransactionStatus transactionStatus;

}
