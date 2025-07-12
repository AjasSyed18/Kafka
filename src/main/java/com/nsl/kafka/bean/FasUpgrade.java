package com.nsl.kafka.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FasUpgrade {
    private String cm_mac;
    private boolean firmware_upgrade_required;
    private String request_id;
    private String ip;
    private String region;
    private String device_type;
    private String embedded_components;
    private String dlqs_info;
    private String snmp_task_id;
    private String transaction_id;
}
