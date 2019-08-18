package com.op.letscode.lock.collections;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockImpl implements RWLock{

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
