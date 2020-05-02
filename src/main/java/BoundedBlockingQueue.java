import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private final int capacity;
    private volatile int [] array;
    private volatile int size;
    private final Lock lock ;
    private final Condition dequeueCondition ;
    private final Condition enqueueCondition ;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
        this.lock = new ReentrantLock();
        this.dequeueCondition = this.lock.newCondition();
        this.enqueueCondition = this.lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size>=capacity){
                enqueueCondition.await();
            }
            size++;
            array[size-1] = element;
            dequeueCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size==0){
                dequeueCondition.await();
            }
            size--;
            int tmp = array[0];
            System.arraycopy(array, 1, array, 0, capacity-1);
            enqueueCondition.signal();
            return tmp;
        }finally {
            lock.unlock();
        }
    }

    public int size() {
        return this.size;
    }

}
