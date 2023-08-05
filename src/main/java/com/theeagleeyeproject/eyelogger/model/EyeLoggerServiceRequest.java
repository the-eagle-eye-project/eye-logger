package com.theeagleeyeproject.eyelogger.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class EyeLoggerServiceRequest {

    @NotNull
    private String integrationId;

    @NotNull
    private String e2eTransactionId;

    @NotNull
    private LocalDateTime eventTimestamp;

    private String requestBody;

    private String requestUri;

    private String sourceHost;

    @NotNull
    private TransactionStatus transactionStatus;

    @NotNull
    private int transactionExecutionTimeMs;

    private String transactionStatusCode;

    private String transactionMessage;

}
