/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.countdown;
import java.util.concurrent.CountDownLatch;


public class DataBaseHCService extends BaseHealthCheckService {

    private CountDownLatch latch;
    private boolean isServiceUp;

    public DataBaseHCService(CountDownLatch latch) {
        super("Database Health Check Service", latch);
        this.latch = latch;
    }

    /**
     * @see com.op.thread.countdown.BaseHealthCheckService#verifyService()
     */
    @Override
    public void verifyService() {
        if (!isServiceUp) {
            System.out.println(" start database services");
            isServiceUp = true;
            latch.countDown();
        }
    }

    public boolean isServiceUp() {
        return isServiceUp;
    }

    public void setServiceUp(boolean isServiceUp) {
        this.isServiceUp = isServiceUp;
    }

}
