package exercise2;

import common.Counter;
import java.util.concurrent.locks.ReentrantLock;

public class LockingCounter implements Counter {
    
    private final ReentrantLock lock = new ReentrantLock();
    private long field = 0;

    @Override
    public void increment() {
        lock.lock();
        try
        {
            this.field++;
        }finally
        {
           lock.unlock();
        }
           
    }

    @Override
    public long getValue() {
        return field;
    }
}
