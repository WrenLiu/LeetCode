
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Solution {

    private static Semaphore signal_O = null;
    private static Semaphore signal_H = null;
    CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) {

        signal_O = new Semaphore(0);
        signal_H = new Semaphore(2);

    }



    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        signal_H.acquire();

        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseHydrogen.run();

        signal_O.release();



    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        signal_O.acquire(2);

        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();

        signal_H.release(2);


    }







}
