package com.nsl.kafka.dataMigSync;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "STG_ATA_DEVICE_SYNC")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StgAtaDeviceSync {

    @Id
    @Column(name = "BATCHD")
    private Integer batchd;

    @Column(name = "MAC_ADDRESS")
    private String macAddress;

    @Column(name = "BATCH_TYPE")
    private String batchType;

    @Column(name = "SYNCHRONIZATION_STATUS")
    private String synchronizationStatus;

    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name = "TRANSACTION_STATUS")
    private String transactionStatus;

    @Column(name = "PROCESS_START_DATE")
    private ZonedDateTime processStartDate;

    @Column(name = "PROCESS_END_DATE")
    private ZonedDateTime processEndDate;

    @Column(name = "ERROR_CODE")
    private String errorCode;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;
}
