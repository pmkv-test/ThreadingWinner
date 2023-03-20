package multithreading;

public class Winner {
    public int count = 0;

    public synchronized int calcCount() {

        while (count >= 100) {

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        count++;
        notify();
        return count;

    }
}


