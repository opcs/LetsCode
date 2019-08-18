/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.lock;

public interface RWLock {

    public void readerLock();

    public void readerUnlock();

    public void writerLock();

    public void writerUnlock();
}
