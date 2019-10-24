package org.quickstart.jmh.counter.implementations;

import java.util.concurrent.atomic.LongAdder;

import org.quickstart.jmh.counter.Counter;

public class Adder implements Counter
{
	private final LongAdder adder = new LongAdder();
	
	public long getCounter()
	{
		return adder.longValue();
	}
	
	public void increment()
	{
		adder.increment();
	}
}
