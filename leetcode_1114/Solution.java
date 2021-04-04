
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Thread01 {

    private static final Object lock1to2 = new Object();
    private static final Object lock2to3 = new Object() ;

    private static final Semaphore signal1to2 = new Semaphore(0);
    private static final Semaphore signal2to3 = new Semaphore(0);


//    private Lock lock01 = new ReentrantLock();
//    Lock lock02 = new ReentrantLock();


    public static void main(String[] args) {

        Foo();

    }


    public static void Foo() {



    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        // 打印函数，不需要做处理
        printFirst.run();
        signal1to2.release(); // 这个信号量是Thread1限制Thread2的，只有释放，才能执行Thread2


    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        signal1to2.acquire();
        printSecond.run();
        signal2to3.release(); // 这个信号量是Thread2限制Thread3的，只有释放，才能执行Thread3

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        signal2to3.acquire();
        printThird.run();


    }


}