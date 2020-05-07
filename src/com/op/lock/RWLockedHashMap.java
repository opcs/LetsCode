
package com.op.lock;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author oprakash
 * @created 21-Mar-2017
 * @vcsid $Id: $
 */
public class RWLockedHashMap<K, V> extends HashMap<K, V> implements RWLock {

    private HashMap<K, V> nameValMap = new HashMap<>();

    private ReadWriteLock m_rwlock = new ReentrantReadWriteLock();

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

    public ReadWriteLock getM_rwlock() {
        return m_rwlock;
    }

    public void setM_rwlock(ReadWriteLock m_rwlock) {
        this.m_rwlock = m_rwlock;
    }


}
