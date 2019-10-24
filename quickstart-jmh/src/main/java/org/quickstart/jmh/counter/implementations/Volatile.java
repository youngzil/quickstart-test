package org.quickstart.jmh.counter.implementations;

import org.quickstart.jmh.counter.Counter;

public class Volatile implements Counter
{
	private volatile long counter;
	
	public long getCounter()
	{
		return counter;
	}
	
	public void increment() 
	{
		++counter;
	}
}