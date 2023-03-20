import multithreading.Player;
import multithreading.Winner;

public class Main {

    public static void main(String[] args) {

        Winner winner = new Winner();
        Player playerOne = new Player(winner);
        Player playerTwo = new Player(winner);
        Thread thredPlayerOne = new Thread(playerOne);
        Thread thredPlayerTwo = new Thread(playerTwo);
        thredPlayerOne.setName("Player1");
        thredPlayerTwo.setName("Player2");

        try {
            thredPlayerOne.start();
            thredPlayerOne.interrupt();
            thredPlayerTwo.start();
            thredPlayerTwo.interrupt();
            thredPlayerOne.join();
            System.out.println(thredPlayerOne.getName() + " count=" + playerOne.playerScore);
            thredPlayerTwo.join();
            System.out.println(thredPlayerTwo.getName() + " count=" + playerTwo.playerScore);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}