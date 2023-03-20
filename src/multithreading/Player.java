package multithreading;

public class Player implements Runnable {
    Winner winner;

    private static final int SCORE_CONST = 100;

    public Player(Winner winner) {
        this.winner = winner;
    }

    public int playerCount = 0;

    @Override
    public void run() {
        for (int i = 0; i <= SCORE_CONST; i++) {

            playerCount = winner.calcCount();

            if (playerCount == SCORE_CONST && Thread.interrupted()) {
                System.out.println("I`m winner! " + Thread.currentThread().getName());
                return;
            }

            if (playerCount == SCORE_CONST-1 && Thread.interrupted()) {
                System.out.println("I`m latter! " + Thread.currentThread().getName());
                return;
            }

        }
    }
}
