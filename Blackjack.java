import java.util.Scanner;
import java.util.Random;
public class Blackjack
{
    private  String name;
    private int cTotalValue;

    //Constants for card bounds
    private static final int UPPER_BOUND = 11;
    private static final int BlackJack = 21;

    public Blackjack() {
        this.cTotalValue = drawCard();
    }

    public int drawCard() {
        Random rand = new Random();
        return rand.nextInt(UPPER_BOUND) + 1; //1-11;
    }

    public void introduction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player name:");
        this.name = sc.nextLine();
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String numm = String.valueOf(cTotalValue);
        return name + ": currently has " + numm;
    }

    public void conditions(int currtotal) {
        if (currtotal > BlackJack) {
            System.out.println(name + " busted! Game over.");
        } else if (currtotal == BlackJack) {
            System.out.println(name + "has 21!! ");
            System.out.println(name + "Wins!");
        }else {
            playGame();
        }
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println(name + ": do you want to DRAW another card, or HOLD?");
        String opt = sc.nextLine();

        switch (opt) {
            case "DRAW":
                int drawnValue = drawCard();
                cTotalValue += drawnValue;
                System.out.println(name + " drew a card with a value of " + drawnValue);
                System.out.println(toString());
                conditions(cTotalValue);

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
