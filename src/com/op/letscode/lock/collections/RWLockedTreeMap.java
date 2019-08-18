package com.op.letscode.lock.collections;

import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockedTreeMap<Key, Value> extends TreeMap<Key, Value> {
	
	RWLockImpl readWriteLocker = new RWLockImpl();

	public Value safePut(Key key, Value value) {
		readWriteLocker.writerLock();
		try {
			return super.put(key, value);
		} finally {
			readWriteLocker.writerUnlock();
		}
	}

}
