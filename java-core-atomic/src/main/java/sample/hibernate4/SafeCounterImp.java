package sample.hibernate4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeCounterImp {    
    
    public static void main(String[] args) throws Exception    
    {   
    	Long start = System.currentTimeMillis();
    	final SafeCounterI safeCounter= new SafeCounter_3();  
        multiThreadCount(safeCounter);
        System.out.println(System.currentTimeMillis() - start);
        
    }
	private static void multiThreadCount(final SafeCounterI safeCounter)
			throws InterruptedException, BrokenBarrierException {
		final int loopcount = 100000;    
        int threadcount = 100;    
        //Non Safe
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(threadcount + 1);
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
        System.out.println("NonSafeCounter:" + safeCounter.get());
	}    
}
interface SafeCounterI{
    public void increase();  
    public long get();
}
class SafeCounter_1 implements SafeCounterI{    
    private long count = 0;    
    public synchronized void increase()    
    {    
        count++;    
    }    
    public long  get()    
    {    
        return count;    
    }    
}
class SafeCounter_2 implements SafeCounterI{    
    private long count = 0;
    Lock lock = new ReentrantLock();
    public void increase()    
    {   
    	try{
    		lock.lock();
    		count++;    
    	}finally{
    		lock.unlock();
    	}
    }    
    public long  get()    
    {    
        return count;    
    }    
}
class SafeCounter_3 implements SafeCounterI{    
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
