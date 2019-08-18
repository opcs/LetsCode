/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class StartupServicesUtil {


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(2);
        List<BaseHealthCheckService> services = new ArrayList<BaseHealthCheckService>(2);

        services.add(new DataBaseHCService(latch));
        services.add(new NetworkHCService(latch));

        Executor executor = Executors.newFixedThreadPool(2);

        for (BaseHealthCheckService baseHealthCheckService : services) {
            executor.execute(baseHealthCheckService);
        }
        System.out.println(latch.getCount());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         
         boolean isAllServiceUp = true;
        System.out.println(latch.getCount());
        if (latch.getCount() == 0) {
            for (BaseHealthCheckService service : services) {
                if (service instanceof NetworkHCService) {
                    NetworkHCService nwkservice = (NetworkHCService) service;
                    System.out.println("thread name: " + nwkservice.getServiceType() + " is Up " + nwkservice.isServiceUp());
                    if (!nwkservice.isServiceUp())
                        isAllServiceUp = false;
                }
                if (service instanceof DataBaseHCService) {
                    DataBaseHCService dbservice = (DataBaseHCService) service;
                    System.out.println("thread name: " + dbservice.getServiceType() + " is Up " + dbservice.isServiceUp());
                    if (!dbservice.isServiceUp())
                        isAllServiceUp = false;
                }
            }
        }
        System.out.println("isallup: " + isAllServiceUp);
    }

}
