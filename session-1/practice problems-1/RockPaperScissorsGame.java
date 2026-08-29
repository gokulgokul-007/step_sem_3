import java.util.*;
public class RockPaperScissorsGame {
    static String playRound(String p, String c) {
        if (p.equals(c)) return "Draw";
        if ((p.equals("Rock") && c.equals("Scissors")) ||
            (p.equals("Paper") && c.equals("Rock")) ||
            (p.equals("Scissors") && c.equals("Paper"))) return "Player Wins";
        return "Computer Wins";
    }
    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] player = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int wins = 0, losses = 0, draws = 0;
        Random r = new Random();
        System.out.println("Round | Player | Computer | Result");
        for (int i = 0; i < 5; i++) {
            String comp = moves[r.nextInt(3)];
            String res = playRound(player[i], comp);
            if (res.equals("Player Wins")) wins++;
            else if (res.equals("Computer Wins")) losses++;
            else draws++;
            System.out.println((i+1) + " | " + player[i] + " | " + comp + " | " + res);
        }
        System.out.println("Wins:" + wins + " Losses:" + losses + " Draws:" + draws + " Win%=" + (wins*100.0/5));
    }
}