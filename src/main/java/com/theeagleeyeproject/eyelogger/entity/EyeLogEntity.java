package com.theeagleeyeproject.eyelogger.entity;

import com.theeagleeyeproject.eyelogger.model.TransactionStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Setter
@Getter
@Document(indexName = "eye-logs-idx")
public class EyeLogEntity {

    @Id
    @Field(name = "transaction_id", type = FieldType.Keyword)
    private String transactionId;

    @Field(name = "integration_id", type = FieldType.Keyword)
    private String integrationId;

    @Field(name = "e2e_transaction_id", type = FieldType.Keyword)
    private String e2eTransactionId;

    @Field(name = "event_timestamp", type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime eventTimestamp;

    @Field(name = "request_body", type = FieldType.Text)
    private String requestBody;

    @Field(name = "request_uri", type = FieldType.Text)
    private String requestUri;

    @Field(name = "source_host", type = FieldType.Text)
    private String sourceHost;

    @Enumerated(EnumType.STRING)
    @Field(name = "transaction_status", type = FieldType.Text)
    private TransactionStatus transactionStatus;

    @Field(name = "transaction_execution_time_ms", type = FieldType.Integer)
    private int transactionExecutionTimeMs;

    @Field(name = "transaction_status_code", type = FieldType.Keyword)
    private String transactionStatusCode;

    @Field(name = "transaction_message", type = FieldType.Text)
    private String transactionMessage;
}
