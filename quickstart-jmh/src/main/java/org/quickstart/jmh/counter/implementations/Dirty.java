package org.quickstart.jmh.counter.implementations;

import org.quickstart.jmh.counter.Counter;

public class Dirty implements Counter
{
	private long counter;
	
	public long getCounter()
	{
		return counter;
	}
	
	public void increment() 
	{
		++counter;
	}
}
