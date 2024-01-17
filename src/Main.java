import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Runnable> list = new ArrayList<Runnable>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            long millis = (long) (Math.random() * 3001 + 3000);
            list.add(new CharPrinter(ch, millis));
        }
        launchThread(list);

    }

    public static void launchThread(List<Runnable> list) throws InterruptedException {
        for (Runnable r : list) {
            Thread thread = new Thread(r);
            thread.start();
            Thread interrupter = new Thread(new ThreadInterrupter(thread));
            interrupter.start();
        }
    }
}
