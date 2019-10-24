package org.quickstart.jmh.counter.implementations;

import java.util.concurrent.atomic.AtomicLong;

import org.quickstart.jmh.counter.Counter;

public class Atomic implements Counter
{
	private final AtomicLong atomic = new AtomicLong();
	
	public long getCounter()
	{
		return atomic.get();
	}
	
	public void increment()
	{
		atomic.incrementAndGet();
	}
}
