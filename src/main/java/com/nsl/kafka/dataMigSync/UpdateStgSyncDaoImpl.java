package com.nsl.kafka.dataMigSync;

import com.nsl.kafka.dataMigSync.DeviceSynchronization;
import com.nsl.kafka.dataMigSync.UpdateStgSyncDao;
import com.nsl.kafka.dataMigSync.StgAtaDeviceSync;
import com.nsl.kafka.dataMigSync.NoRecordsFoundException;
import com.nsl.kafka.dataMigSync.StgAtaDeviceSyncRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateStgSyncDaoImpl implements UpdateStgSyncDao {

    @Autowired
    private StgAtaDeviceSyncRepo stgAtaDeviceSyncRepo;

    @Override
    public void UpdateTrans(DeviceSynchronization deviceSyncReq) {
        if (stgAtaDeviceSyncRepo.existsById(Long.valueOf(deviceSyncReq.getBatchId()))) {
            StgAtaDeviceSync ataDeviceSync = StgAtaDeviceSync.builder()
                    .transactionId(deviceSyncReq.getTransactionId())
                    .synchronizationStatus(deviceSyncReq.getSynchronizationStatus())
                    .build();
            stgAtaDeviceSyncRepo.save(ataDeviceSync);
        } else {
            throw new NoRecordsFoundException("No record found for the given batch ID");
        }
    }
}
