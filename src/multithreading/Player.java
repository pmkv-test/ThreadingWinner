package multithreading;

public class Player implements Runnable {
    Winner winner;

    public Player(Winner winner) {
        this.winner = winner;
    }

    public int playerScore = 0;

    @Override
    public void run() {
        int scorePlayerMax = winner.scoreMax;

        for (int i = 0; i <= scorePlayerMax; i++) {

            playerScore = winner.calcScore();

            if (playerScore == scorePlayerMax && Thread.interrupted()) {
                System.out.println("I`m winner! " + Thread.currentThread().getName());
                return;
            }

            if (playerScore == scorePlayerMax -1 && Thread.interrupted()) {
                System.out.println("I`m latter! " + Thread.currentThread().getName());
                return;
            }

        }
    }
}
