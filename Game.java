import java.util.Random;
import java.util.Scanner;
public class Game {

    private Player player;
    private String playerName;
    private int currentValue;

    //Constants for card bounds
    private static final int UPPER_BOUND = 11;
    private static final int BlackJack = 21;

    public Game(){
        introduction();
        playerName = player.getName();
        currentValue = player.getCurrentValue();
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
         this.player.setCurrentValue(drawCard());
         System.out.println(player.toString());
    }

    public void conditions(int CurrentValue) {
        if (CurrentValue > BlackJack) {
            System.out.println(playerName + " busted! Game over.");
        } else if (CurrentValue == BlackJack) {
            System.out.println(playerName + "has 21!! ");
            System.out.println(playerName + "Wins!");
        }else {
            playGame();
        }
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println(playerName + ": do you want to DRAW another card, or HOLD?");
        String opt = sc.nextLine();

        switch (opt) {
            case "DRAW":
                int drawnValue = drawCard();
                player.updateCurrentValue(drawnValue);
                System.out.println(playerName + " drew a card with a value of " + drawnValue);
                System.out.println(player.toString());
                conditions(player.getCurrentValue());
                break;
            case "HOLD":
                System.out.println("Its a draw :/");
                break;
            default:
                System.out.println("Invalid option. Please enter DRAW or HOLD.");
                playGame();
                break;
        }
    }
}

