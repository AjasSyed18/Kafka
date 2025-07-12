package com.nsl.kafka.dataMigSync;

import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
public class UpdateStgSyncController {

    @Autowired
    private UpdateStgSyncService updateStgSyncService;

    @PostMapping(path = "/updateStgSync", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject updateStgSync(@RequestBody DeviceSynchronization request){/*
        try {
            StgAtaDeviceSync stgAtaDeviceSync = updateStgSyncService.UpdateTrans(request);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(stgAtaDeviceSync);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        try{
            updateStgSyncService.UpdateTrans(request);
            JSONObject resp = new JSONObject("result");
            resp.put("code", "200").put("message", "STG_ATA_Device_Sync is updated successfully");
            return resp;
        } catch (JSONException e) {
            throw new NoRecordsFoundException("Record not found");
        }
    }
}
