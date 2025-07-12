package com.nsl.kafka.dataMigSync;

import com.nsl.kafka.dataMigSync.StgAtaDeviceSync;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StgAtaDeviceSyncRepo extends JpaRepository<StgAtaDeviceSync, Long> {
}
