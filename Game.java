import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Game {

    private Player player;
    private final String playerName;
    private int DrawnValue;
    private ArrayList<String> history = new ArrayList<>(); // ArrayList to store history

    //Constants for card bounds
    private static final int UPPER_BOUND = 11;
    private static final int BlackJack = 21;

    public Game(){
        introduction();
        playerName = player.getName();
    }
    public int drawCard() {
        Random rand = new Random();
        return rand.nextInt(UPPER_BOUND) + 1; //1-11;
    }

    public void introduction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player name:");
         String playerName = sc.nextLine();

         this.player = new Player(playerName);
         player.setCurrentDrawnValue(drawCard());
         DrawnValue = player.getCurrentDrawnValue();
         this.player.setCurrentValue(DrawnValue);

         System.out.println(player.toString());
         history.add(toString());

    }


    public void playGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println(playerName + ": do you want to DRAW another card, or HOLD?");
        String Option = sc.nextLine();
        output(Option);
    }

    public void output(String Option){
        switch (Option) {
            case "DRAW" -> {
                DrawnValue = drawCard();
                player.setCurrentDrawnValue(DrawnValue);
                player.updateCurrentValue(DrawnValue);
                System.out.println(player.toString());
                history.add(player.toString());

                if (player.getCurrentValue() > BlackJack) {
                    history.add(playerName + " busted! Game Over");
                    System.out.println(playerName + " busted! Game over.");
                } else if (player.getCurrentValue() == BlackJack) {
                    //System.out.println(playerName + "has 21!! ");
                    history.add(playerName + "Won! Game Over");
                    System.out.println(playerName + " Wins!");
                } else {
                    playGame();
                }
            }
            case "HOLD" ->{
                history.add(playerName + " Drew");
                System.out.println("Its a draw :/");
            }
            default -> {
                history.add("Invalid option. Please enter DRAW or HOLD.");
                System.out.println("Invalid option. Please enter DRAW or HOLD.");
                playGame();
            }
        }
    }
    // Getter method for history
    public ArrayList<String> getHistory() {
        return history;
    }

    // Setter method for history
    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
    public void showHistory() {
        System.out.println("Game History:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }

}

