package com.op.lock;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class LockedHashMap extends HashMap implements RWLock{

	ReadWriteLock m_rwlock = new ReentrantReadWriteLock();

	@Override
	public void readerLock() {
		m_rwlock.readLock().lock();
		
	}

	@Override
	public void readerUnlock() {
		m_rwlock.readLock().unlock();
		
	}

	@Override
	public void writerLock() {
		m_rwlock.writeLock().lock();
		
	}

	@Override
	public void writerUnlock() {
		m_rwlock.writeLock().unlock();
		
	}

}
