
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.function.IntConsumer;

public class Solution {

    private static int n;
    private Semaphore signal0 = new Semaphore(1);

    private Semaphore signalEven = new Semaphore(0);
    private Semaphore signalOdd = new Semaphore(0);

    public static void main(String[] args) {


        n = 10;


    }

    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            signal0.acquire();
            printNumber.accept(0);
            if(i % 2 == 0){
                signalOdd.release();
            }else{
                signalEven.release();
            }


        }



    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 2; i <= n; i+=2) {
            signalEven.acquire();
            printNumber.accept(i);
            signal0.release();

        }


    }

    public void odd(IntConsumer printNumber) throws InterruptedException {


        for (int i = 1; i <= n; i+=2) {

            signalOdd.acquire();
            printNumber.accept(i);
            signal0.release();

        }


    }


}
