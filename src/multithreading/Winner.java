package multithreading;

public class Winner {

    private static final int SCORE_CONST = 100;

    public int scoreMax = SCORE_CONST;

    public int score = 0;

    public synchronized int calcScore() {

        while (score >= SCORE_CONST) {

            try {

                wait();

            } catch (InterruptedException e) {

                throw new RuntimeException(e);

            }
        }

        score++;
        notify();
        return score;

    }
}


