package com.op.letscode.lock.collections;

public interface RWLock {

	public void readerLock();
	public void readerUnlock();
	public void writerLock();
	public void writerUnlock();
}
