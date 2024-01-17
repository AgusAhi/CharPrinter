import java.util.*;

public class ThreadInterrupter implements Runnable {
    private Thread threadInterrupt;

    public ThreadInterrupter(Thread threadInterrupt) {
        this.threadInterrupt = threadInterrupt;
    }

    @Override
    public void run() {
        int time = (int) (Math.random() * 20001 + 10000);
        try {
            Thread.sleep(time);
            threadInterrupt.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
