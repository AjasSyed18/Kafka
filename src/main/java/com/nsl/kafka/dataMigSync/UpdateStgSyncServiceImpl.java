package com.nsl.kafka.dataMigSync;

import com.nsl.kafka.dataMigSync.DeviceSynchronization;
import com.nsl.kafka.dataMigSync.UpdateStgSyncDao;
import com.nsl.kafka.dataMigSync.UpdateStgSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStgSyncServiceImpl implements UpdateStgSyncService {

    @Autowired
    private UpdateStgSyncDao updateStgSyncDao;

    @Override
    public void UpdateTrans(DeviceSynchronization stgAtaDeviceSync) {
        updateStgSyncDao.UpdateTrans(stgAtaDeviceSync);
    }
}
