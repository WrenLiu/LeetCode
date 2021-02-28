

import java.util.concurrent.Semaphore;

public class Solution {
    private static int n;

    private static Semaphore signal01 = null;
    private static Semaphore signal02 = null;
    
    public static void main(String[] args) {
        n = 10;
        signal01 = new Semaphore(1);
        signal02 = new Semaphore(0);
    }


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            signal01.acquire();
            System.out.print("Foo");
            signal02.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            signal02.acquire();
            System.out.print("Bar");
            signal01.release();
        }
    }
}
