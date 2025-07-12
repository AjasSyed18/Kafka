package com.nsl.kafka.dataMigSync;

import com.nsl.kafka.dataMigSync.DeviceSynchronization;

public interface UpdateStgSyncDao {
    public void UpdateTrans(DeviceSynchronization stgAtaDeviceSync);
}
