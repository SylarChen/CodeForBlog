package sample.hibernate4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;

public class CounterTest {    
    
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException    
    {    
        final int loopcount = 10000;    
        int threadcount = 10;    
        //Non Safe
        final NonSafeCounter nonSafeCounter = new NonSafeCounter();    
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(threadcount + 1);
        for(int i = 0; i < threadcount; ++i)    
        {
        	final int index = i; 
            new Thread(new Runnable() {    
                @Override    
                public void run() {    
                    for(int j = 0; j < loopcount; ++j)    
                    {    
                    	nonSafeCounter.increase();
                    }
                    try {
						cyclicBarrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
                    System.out.println("Thread Finished: " + index);
                }    
            }).start();    
        }
        cyclicBarrier.await();
        Thread.sleep(300);
        System.out.println("NonSafeCounter:" + nonSafeCounter.get());    
    
        
        //Safe
        final SafeCounter safeCounter = new SafeCounter();    
        for(int i = 0; i < threadcount; ++i)    
        {
        	final int index = i; 
            new Thread(new Runnable() {    
                @Override    
                public void run() {    
                    for(int j = 0; j < loopcount; ++j)    
                    {    
                    	safeCounter.increase();
                    }
                    try {
						cyclicBarrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
                    System.out.println("Thread Finished: " + index);
                }    
            }).start();    
        }
        cyclicBarrier.await();
        Thread.sleep(300);
        System.out.println("SafeCounter:" + safeCounter.get());    
    }    
}    
    
class NonSafeCounter{    
    private volatile long count = 0;    
    public void increase()    
    {    
        count++;    
    }    
    
    public long  get()    
    {    
        return count;    
    }    
}    
    
class SafeCounter{    
    private AtomicLong atomicLong  = new AtomicLong(0);
    public void increase()    
    {    
    	atomicLong.incrementAndGet();
    }    
    
    public long get()    
    {    
        return atomicLong.longValue();    
    }    
}   
