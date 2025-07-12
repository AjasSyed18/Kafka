package com.nsl.kafka.dataMigSync;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceSynchronization {
    private Integer batchId;
    private String macAddress;
    private String batchType;
    private String synchronizationStatus;
    private Long transactionId;
    private String transactionStatus;
    private ZonedDateTime processStartDate;
    private ZonedDateTime processEndDate;
    private String errorCode;
    private String errorMessage;
}
