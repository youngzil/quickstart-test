package org.quickstart.jmh.counter.implementations;

import java.util.concurrent.locks.StampedLock;

import org.quickstart.jmh.counter.Counter;

public class Stamped implements Counter {

	private StampedLock rwlock = new StampedLock();
	
	private long counter;
	public long s, t;
	
	public long getCounter()
	{
		long stamp = rwlock.tryOptimisticRead();
		
		try
		{
			long result = counter;
			
			if (rwlock.validate(stamp))
			{
				return result;
			}
			
			stamp = rwlock.readLock();
			
			result = counter;
			
			rwlock.unlockRead(stamp);
			
			return counter;
		}
		finally
		{
			
		}
	}
	
	public void increment()
	{
		long stamp = rwlock.writeLock();
		
		try
		{	
			++counter;
		}
		finally
		{
			rwlock.unlockWrite(stamp);
		}
	}
}
