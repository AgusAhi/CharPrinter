public class CharPrinter implements Runnable {

private char ch;
private long milliseconds;

    public CharPrinter(char ch, long milliseconds) {
        this.ch = ch;
        this.milliseconds = milliseconds;
    }

    public void run() {
        int counter = 0;
        try {
            while (true) {
                System.out.print(ch);
                counter++;
                if (counter == 5) {
                    System.out.print("\n");
                    counter = 0;
                }
                Thread.sleep(milliseconds);
            }
        } catch (InterruptedException e) {
            System.out.println("\n" + ch + " interrupted");
        }
    }
}
